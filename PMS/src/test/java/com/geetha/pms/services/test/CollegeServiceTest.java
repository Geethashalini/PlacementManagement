package com.geetha.pms.services.test;

import com.geetha.pms.entities.College;
import com.geetha.pms.exceptions.EntityNotFoundException;
import com.geetha.pms.repositories.CollegeRepository;
import com.geetha.pms.services.CollegeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit test class for {@link CollegeService}.
 */
public class CollegeServiceTest {

    @Mock
    private CollegeRepository collegeRepository;

    @InjectMocks
    private CollegeService collegeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test for listing all colleges.
     * It should return a list of colleges.
     */
    @Test
    public void testListAll() {
        College college1 = new College(1, "ABC College", "New York", null);
        College college2 = new College(2, "XYZ College", "California", null);
        List<College> colleges = Arrays.asList(college1, college2);

        when(collegeRepository.findAll()).thenReturn(colleges);

        List<College> result = collegeService.listAll();

        assertEquals(2, result.size());
        verify(collegeRepository, times(1)).findAll();
    }

    /**
     * Test for getting a college by ID.
     * It should return the college if found.
     */
    @Test
    public void testGetCollege() {
        College college = new College(1, "ABC College", "New York", null);

        when(collegeRepository.findById(1)).thenReturn(Optional.of(college));

        College result = collegeService.get(1);

        assertNotNull(result);
        assertEquals("ABC College", result.getCollegeName());
        verify(collegeRepository, times(1)).findById(1);
    }

    /**
     * Test for saving a college.
     * It should return the saved college.
     */
    @Test
    public void testSaveCollege() {
        College college = new College(1, "ABC College", "New York", null);

        when(collegeRepository.save(any(College.class))).thenReturn(college);

        College result = collegeService.save(college);

        assertNotNull(result);
        assertEquals("ABC College", result.getCollegeName());
        verify(collegeRepository, times(1)).save(college);
    }

    /**
     * Test for deleting a college.
     * It should delete the college if it exists.
     */
    @Test
    public void testDeleteCollege() {
        when(collegeRepository.existsById(1)).thenReturn(true);
        doNothing().when(collegeRepository).deleteById(1);

        collegeService.delete(1);

        verify(collegeRepository, times(1)).existsById(1);
        verify(collegeRepository, times(1)).deleteById(1);
    }

    /**
     * Test for getting a college by ID that doesn't exist.
     * It should throw an EntityNotFoundException.
     */
    @Test
    public void testGetCollege_NotFound() {
        when(collegeRepository.findById(99)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> collegeService.get(99));
    }

    // Example failing test cases:
    // @Test
    // public void testDeleteCollege_NotFound() {
    //     when(collegeRepository.existsById(99)).thenReturn(false);
    //
    //     assertThrows(EntityNotFoundException.class, () -> collegeService.delete(99));
    // }
}

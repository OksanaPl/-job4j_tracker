package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    public void whenComparatorUpByName() {
        List<Job> jobs = Arrays.asList(
                new Job("B", 1),
                new Job("A", 0)
        );
        List<Job> expected = new ArrayList<>();
        Job j1 = new Job("A", 0);
        Job j2 = new Job("B", 1);
        expected.add(j1);
        expected.add(j2);
        jobs.sort(new JobUpByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("A", 0),
                new Job("B", 1)
        );
        List<Job> expected = new ArrayList<>();
        Job j1 = new Job("B", 1);
        Job j2 = new Job("A", 0);
        expected.add(j1);
        expected.add(j2);
        jobs.sort(new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorUpByPriority() {
        Comparator<Job> upPriority = new JobUpByPriority();
        int rsl = upPriority.compare(
                new Job("A", 1),
                new Job("A", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> descPriority = new JobDescByPriority();
        int rsl = descPriority.compare(
                new Job("A", 1),
                new Job("A", 0)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorDescByNameOrPriority() {
        Comparator<Job> descNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = descNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorUpByNameOrPriority() {
        Comparator<Job> upNamePriority = new JobUpByName().thenComparing(new JobUpByPriority());
        int rsl = upNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}

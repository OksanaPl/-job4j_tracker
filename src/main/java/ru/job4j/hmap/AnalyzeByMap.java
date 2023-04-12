package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double element = 0;
        double score = 0;
        for (Pupil p : pupils) {
            for (Subject s : p.subjects()) {
                element++;
                score += s.score();
            }
        }
        return score / element;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> namePupils = new ArrayList<>();
        for (Pupil p : pupils) {
            double element = 0;
            double score = 0;
            for (Subject s : p.subjects()) {
                element++;
                score += s.score();
            }
            Label label = new Label(p.name(), score / element);
            namePupils.add(label);
        }
        return namePupils;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> averageScoreSubject = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : map.keySet()) {
            averageScoreSubject.add(new Label(key, (map.get(key) / pupils.size())));
        }

        return averageScoreSubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> theBestStudent = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject s : pupil.subjects()) {
                score += s.score();
            }
            Label label = new Label(pupil.name(), score);
            theBestStudent.add(label);
            Collections.sort(theBestStudent);

        }
        return theBestStudent.get(theBestStudent.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> theBestSubject = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : map.keySet()) {
            theBestSubject.add(new Label(key, map.get(key)));
            Collections.sort(theBestSubject);
        }

        return theBestSubject.get(theBestSubject.size() - 1);
    }
}

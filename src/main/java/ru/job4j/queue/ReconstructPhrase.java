package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder result = new StringBuilder();
        final int evenSize = evenElements.size() / 2;
        for (int i = 0; i < evenSize; i++) {
            result.append(evenElements.poll());
            evenElements.poll();
        }
        return String.valueOf(result);
    }

    private String getDescendingElements() {
        StringBuilder rsl = new StringBuilder();
        final int descSize = descendingElements.size();
        for (int i = 0; i < descSize; i++) {
            rsl.append(descendingElements.pollLast());

        }
        return String.valueOf(rsl);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}

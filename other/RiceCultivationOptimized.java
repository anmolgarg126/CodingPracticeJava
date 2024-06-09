package other;

import java.util.PriorityQueue;
import java.util.Queue;

public class RiceCultivationOptimized {

    /*
    a map of village is split into rectangular grid with N rows(numbered from 0 to N-1) and
    M columns(numbered from 0 to M-1). Establish at most two rice cultivation areas in the village,
    using only cells dedicated for the purpose.

    The map is described by an array of strings: the C-th character of the R-th string can be either '.',
    meaning that cell can be used for cultivating rice, or '#' meaning rice can not be cultivated.

    The shape of the cultivation areas should be a narrow rectangle(vertical with one cell width or horizontal
    with one cell height). The areas cannot share cells, but can share a side.

    What is the maximum number of cells that can be used for cultivation by choosing at most two areas?
     */

    static class Field {
        Integer row;
        Integer col;
        int count;
        int startIndex;
        int endIndex;

        Field(Integer row, int count, Integer col, int startIndex, int endIndex) {
            this.row = row;
            this.count = count;
            this.col = col;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public char getType() {
            return row == null ? 'c' : 'r';
        }
    }

    public static int maxRiceCells(String[] village) {
        int N = village.length;
        int M = village[0].length();

        Queue<Field> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        for (int i = 0; i < N; i++) {
            pq.add(countValidRows(village[i], i));
        }

        for (int j = 0; j < M; j++) {
            pq.add(countValidCellsInColumn(village, j));
        }

        Field first = pq.poll();
        int res = first.count;

        outer:
        while (!pq.isEmpty()) {
            if (first.getType() == pq.peek().getType()) {
                res += pq.poll().count;
                break;
            } else if (first.getType() == 'r') {
                Field temp = pq.poll();
                int second = getClashingIndex(first, temp);
                while (!pq.isEmpty()) {
                    int curr = 0;
                    if (first.getType() == pq.peek().getType()) {
                        curr = pq.poll().count;
                    } else {

                        curr = getClashingIndex(first, pq.poll());
                    }
                    if (curr > second) {
                        res += curr;
                        break outer;
                    }
                }
                res += second;
                break;
            }
        }

        return res;
    }

    private static Field countValidRows(String row, int i) {
        int count = 0;
        int r = 0, curr = 0;
        int start = 0, end = 0;
        while (r < row.length()) {
            if (row.charAt(r) != '.') {
                if (curr > count) {
                    count = curr;
                    start = r - curr;
                    end = r - 1;
                }
                curr = 0;
            } else {
                curr++;
            }
            r++;
        }

        if (curr > count) {
            count = curr;
            start = r - curr;
            end = r - 1;
        }

        return new Field(i, count, null, start, end);
    }

    private static Field countValidCellsInColumn(String[] village, int col) {
        int count = 0;
        int r = 0, curr = 0;
        int start = 0, end = 0;
        while (r < village.length) {
            if (village[r].charAt(col) != '.') {
                if (curr > count) {
                    count = curr;
                    start = r - curr;
                    end = r - 1;
                }
                curr = 0;
            } else {
                curr++;
            }
            r++;
        }

        if (curr > count) {
            count = curr;
            start = r - curr;
            end = r - 1;
        }
        return new Field(null, count, col, start, end);
    }

    private static int getClashingIndex(Field a, Field b) {
        if (a.getType() == 'r') {
            if (a.startIndex <= b.col && a.endIndex >= b.col) {
                return Math.max(Math.abs(b.startIndex - a.row), Math.abs(b.endIndex - a.row));
            }
        } else {
            if (b.startIndex <= a.col && b.endIndex >= a.col) {
                return Math.max(Math.abs(b.startIndex - a.row), Math.abs(b.endIndex - a.row));
            }
        }
        return b.count;
    }

    public static void main(String[] args) {
//        String[] village = {
//            "##.###",
//            "##.###",
//            "..####",
//            ".#####",
//            "######"
//        };

        String[] village = {
                ".##..",
                ".#.#.",
                ".....",
                "##..#"
        };
        int maxCells = maxRiceCells(village);
        System.out.println("Maximum number of cells for cultivation: " + maxCells);
    }
}

package Lesson_7;

import java.util.*;

public class Graph {
    private final List<Vertex> vertexList;

    public void setAdjMat(boolean[][] adjMat) {
        this.adjMat = adjMat;
    }

    private boolean[][] adjMat;

    private int size;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        size++;
    }

//    ------------------------------------------------

    public void addEdges(String start, String second, String... others) {
        addEdge(start, second);
        for (String another : others) {
            addEdge(start, another);
        }
    }

    public void addEdge(String start, String finish) {
        int startIndex = indexOf(start);
        int finishIndex = indexOf(finish);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid label for vertex");
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
    }

//    ------------------------------------------------

    private int indexOf(String label) {
        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

//    ------------------------------------------------

    /**
     * англ. Depth-first search, DFS
     *
     * @param startLabel
     */
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);

        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }

        resetVertexState();
    }

    /**
     * англ. breadth-first search, BFS
     *
     * @param startLabel
     */
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }

        resetVertexState();

    }


//    ------------------------------------------------

    public void findBFS(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Vertex vertexLast = null;

        Queue<Vertex> queue = new LinkedList<>();
        //Доп лист, по которому назад найду выход
        boolean[][] away = new boolean[adjMat.length][adjMat.length];

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);


        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());

            if (vertex != null) {
                vertexLast = queue.peek();
                visitVertex(queue, vertex);
                away[indexOf(vertexLast.getLabel())][indexOf(vertex.getLabel())] = true;
                away[indexOf(vertex.getLabel())][indexOf(vertexLast.getLabel())] = true;
                if (vertex.getLabel().equals(endLabel)) {
                    System.out.println("Нашёл кратчайший путь от " + startLabel + " до " + endLabel + ":");
                    Graph halfGraph = new Graph(adjMat.length);
                    for (Vertex v : vertexList)
                        halfGraph.addVertex(v.getLabel());
                    halfGraph.setAdjMat(away);
                    System.out.println(halfGraph.findWay(endLabel, startLabel));
                    break;
                }
            } else {
                queue.remove();
            }
        }
        resetVertexState();
    }

    public Stack<Vertex> findWay(String startLabel, String endLabel) {
        Stack<Vertex> way = new Stack<>();

        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(way, vertex);

        while (!way.isEmpty()) {
            vertex = getNearUnvisitedVertex(way.peek());

            if (vertex != null) {
                visitVertex(way, vertex);
                if (vertex.getLabel().equals(endLabel)) {
                    return reverse(way);
                }
            } else {
                way.pop();
            }
        }
        return way;
    }

//    ------------------------------------------------

    private void resetVertexState() {
        for (int i = 0; i < size; i++) {
            vertexList.get(i).setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);
        for (int i = 0; i < size; i++) {
            if (adjMat[peekIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }

        return null;
    }

//    ------------------------------------------------

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        displayVertex(vertex);
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        displayVertex(vertex);
        queue.add(vertex);
        vertex.setVisited(true);
    }

//    ------------------------------------------------


    private void displayVertex(Vertex vertex) {
        System.out.println(vertex);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public Stack<Vertex> reverse(Stack<Vertex> way) {
        Stack<Vertex> returnWay = new Stack<>();
        for (int i = way.size() - 1; i > -1; i--)
            returnWay.add(way.get(i));
        return returnWay;
    }

    public Stack<String> findShortPathViaBfs(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (startIndex == -1)
            throw new IllegalArgumentException("Нет такого города - " + startLabel);

        if (finishIndex == -1)
            throw new IllegalArgumentException("Нет такого города - " + finishLabel);

        Queue<Vertex> queue = new ArrayDeque<Vertex>();

        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex == null) {
                queue.remove();
            } else {
                visitVertex(queue, vertex);
                vertex.setPreviousVertex(queue.peek());
                if (vertex.getLabel().equals(finishLabel)) {
                    return buildPath(vertex);
                }
            }
        }

        resetVertexState();
        return null;
    }


    private Stack<String> buildPath(Vertex vertex) {
        Stack<String> stack = new Stack<>();
        Vertex current = vertex;
        while (current != null) {
            stack.push(current.getLabel());
            current = current.getPreviousVertex();
        }

        return stack;
    }

}

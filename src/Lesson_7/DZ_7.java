package Lesson_7;

public class DZ_7 {
    public static void main(String[] args) {
        Graph road_map = makeGraph();
        road_map.bfs("Москва");
        System.out.println("----------------------------");
        road_map.dfs("Москва");
    }



    private static Graph makeGraph() {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орёл");
        graph.addVertex("Курск");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdges("Воронеж", "Липецк", "Саратов", "Курск");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Калуга", "Орёл");
        graph.addEdge( "Орёл", "Курск");

        return graph;
    }

}

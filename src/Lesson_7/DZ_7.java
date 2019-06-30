package Lesson_7;

import java.util.Stack;

public class DZ_7 {
    public static void main(String[] args) {
        Graph road_map = makeGraph();
//        road_map.bfs("Москва");
//        System.out.println("----------------------------");
//        road_map.dfs("Москва");

        road_map.findBFS("Новомосковск", "Саратов");

        Stack<String> path = road_map.findShortPathViaBfs("Новомосковск", "Саратов");
        System.out.println("Кратчайший путь:");
        showShortPath(path);
    }



    private static Graph makeGraph() {
        Graph graph = new Graph(13);
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

        //Для проверки, города прицеплены к Туле
        graph.addVertex("Новомосковск");
        graph.addVertex("Узловая");

        //Для проверки, города прицеплен к Липецку
        graph.addVertex("Елец");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdges("Воронеж", "Липецк", "Саратов", "Курск");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Калуга", "Орёл");
        graph.addEdge( "Орёл", "Курск");

        //Для проверки, города прицеплены к Липецку и ещё связаны
        graph.addEdge("Тула", "Новомосковск");
        graph.addEdge("Тула", "Узловая");
        graph.addEdge("Новомосковск", "Узловая");

        graph.addEdge("Липецк", "Елец");

        return graph;
    }

    private static void showShortPath(Stack<String> path) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        while(!path.isEmpty()) {
            if(!isFirst)
                sb.append(" -> ");
            isFirst = false;
            sb.append(path.pop());
        }
        System.out.println(sb);
    }

}

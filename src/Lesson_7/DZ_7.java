package Lesson_7;

public class DZ_7 {
    public static void main(String[] args) {
        Graph road_map = makeGraph();
//        road_map.bfs("Москва");
//        System.out.println("----------------------------");
//        road_map.dfs("Москва");

        road_map.findBFS("Новомосковск", "Саратов");
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

}

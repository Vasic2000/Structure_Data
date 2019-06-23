package Lesson_4.LinkApp;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkInterator itr = new LinkInterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        itr.insertBefore("Leonid", 15);

        list.display();
        System.out.println("\n___________");

        System.out.println(itr.infoCurrent());
        itr.deleteCurrent();
        System.out.println("Удалено...");
        System.out.println("\n___________");

        System.out.println("Остались:");
        list.display();
    }
}

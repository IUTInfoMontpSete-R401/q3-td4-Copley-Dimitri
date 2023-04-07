package pattern;

public class LineView implements ViewComponent {
    private ViewComponent[] children;

    public LineView(int size) {
        this.children = new ViewComponent[size];
    }

    @Override
    public void display() {
        for (int i = 0; i < children.length; i++) {
            children[i].display();
            System.out.println();
        }
    }

    public void setChild(int index, ViewComponent child) {
        children[index] = child;
    }

    public ViewComponent[] getChildren() {
        return children;
    }
}

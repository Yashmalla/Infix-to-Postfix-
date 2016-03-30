
public interface List {
	int getSize();
	void insertFront(Object item);
	void insertBack(Object item);
	Object removeFront();
	Object removeBack();
	Object get(int index);
}

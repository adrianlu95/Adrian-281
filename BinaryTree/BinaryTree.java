import java.util.Collection;
import java.util.Iterator;

public class BinaryTree implements Collection {

	BinaryTree rightSubTree = null;
	BinaryTree leftSubTree = null;
	Object data = null;
	
	public BinaryTree(Object val) {
		this.data = val;
	}
	
	public static BinaryTree createFromData(Object val, BinaryTree leftTree, BinaryTree rightTree) {
		BinaryTree tree = new BinaryTree(val);
		tree.leftSubTree = leftTree;
		tree.rightSubTree = rightTree;
		return tree;
	}
	
	public boolean add(Object val) {
		if(hasLeft()) {
			return this.leftSubTree.add(val);
		}
		this.leftSubTree = new BinaryTree(val);
		return true;
	}

	public boolean addAll(Collection collection) {
		boolean changed = true;
		for(Object o: collection) {
			changed |= this.add(o);
		}
		return changed;
	}
	
	public void clear() {
		this.data = null;
		this.leftSubTree = null;
		this.rightSubTree = null;
	}
	
	public boolean contains(Object val) {
		if(this.data.equals(val)) {
			return true;
		}
		if(this.leftSubTree.contains(val)) {
			return true;
		}
		return this.rightSubTree.contains(val);
	}

	
	public boolean containsAll(Collection collection) {
		for(Object val: collection) {
			if(!this.contains(val)) {
				return false;
			}
		}
		return true;
	}

	
	public boolean isEmpty() {
		boolean selfHasNoData = (this.data == null);
		boolean leftIsEmpty = true;
		boolean rightIsEmpty = true;
		if(hasLeft()) {
			leftIsEmpty = this.leftSubTree.isEmpty();
		}
		if(hasRight()) {
			rightIsEmpty = this.rightSubTree.isEmpty();
		}
		return selfHasNoData && leftIsEmpty && rightIsEmpty;
	}
	
	private boolean hasLeft() {
		return this.leftSubTree != null;
	}
	
	private boolean hasRight() {
		return this.rightSubTree != null;
	}
	
	private Object[] preorder(Object[] array) {
		if(this.data != null) {
			array = appendTo(data, array);
		}
		if(hasLeft()) {
			array = this.leftSubTree.preorder(array);
		}
		if(hasRight()) {
			array = this.rightSubTree.preorder(array);
		}
		return array;
	}
	
	private Object[] toPreOrder() {
		Object[] arr = new Object[0];
		arr = this.preorder(arr);
		return arr;
	}
	
	private Object[] inorder(Object[] array) {
		if(hasLeft()) {
			array = this.leftSubTree.inorder(array);
		}
		if(this.data != null) {
			array = appendTo(data, array);
		}
		if(hasRight()) {
			array = this.rightSubTree.inorder(array);
		}
		return array;
	}
	
	private Object[] toInOrder() {
		Object[] arr = new Object[0];
		arr = this.inorder(arr);
		return arr;
	}
	
	private Object[] postorder(Object[] array) {
		if(hasLeft()) {
			array = this.leftSubTree.postorder(array);
		}
		if(hasRight()) {
			array = this.rightSubTree.postorder(array);
		}
		if(this.data != null) {
			array = appendTo(data, array);
		}
		return array;
	}
	
	private Object[] toPostOrder() {
		Object[] arr = new Object[0];
		arr = this.postorder(arr);
		return arr;
	}
	
	private static Object[] appendTo(Object val, Object[] array) {
		Object[] newArray = new Object[array.length+1];
		for(int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		newArray[array.length] = val;
		
		return newArray;
	}

	
	public Iterator iterator() {
		
		return new Iterator() {

			Object[] array = toPreOrder();
			int index = -1;
			public boolean hasNext() {
				return index + 1 > array.length;
			}

			public Object next() {
				index++;
				return array[index];
			}

			public void remove() {
				BinaryTree.this.remove(array[index]);
			}
		};
	}

	
	public boolean remove(Object val) {
		if(this.data.equals(val)) {
			throw new UnsupportedOperationException("I really don't know what you're expecting this to do.");
			//return true;
		}
		if(this.leftSubTree!= null && this.leftSubTree.remove(val)) {
			return true;
		}
		if(this.rightSubTree!= null && this.rightSubTree.remove(val)) {
			return true;
		}
		return false;
	}

	
	public boolean removeAll(Collection collection) {
		boolean changed = true;
		for(Object o: collection) {
			changed |= this.remove(o);
		}
		return changed;
	}

	
	public boolean retainAll(Collection collection) {
		boolean changed = false;
		for(Object o: this) {
			if(!collection.contains(o)) {
				changed |= this.remove(o);
			}
		}
		return changed;
	}

	
	public int size() {
		return toInOrder().length;
	}

	
	public Object[] toArray() {
		return toInOrder();
	}

	
	public Object[] toArray(Object[] arr) {
		if(arr == null) {
			arr = new Object[0];
		}
		inorder(arr);
		return arr;
	}
	
	public String toString() {
		String ret = "";
		Object[] arr = toInOrder();
		for(Object o: arr) {
			ret += o.toString() + ", ";
		}
		return ret;
	}

}

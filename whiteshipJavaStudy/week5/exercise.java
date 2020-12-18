package whiteshipJavaStudy.week5;

import java.util.LinkedList;
import java.util.Queue;

/*
	int 값을 가지고 있는 이진 트리를 나타내는 Node 라는 클래스를 정의하세요.
	int value, Node left, right를 가지고 있어야 합니다.
	BinrayTree라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node)와 dfs(Node node) 메소드를 구현하세요.
	DFS는 왼쪽, 루트, 오른쪽 순으로 순회하세요.

	https://github.com/whiteship/live-study/issues/5
*/

class Node{
	private int value;
	private Node left;
	private Node right;

	public Node(int value){
		this(value, null, null);
	}

	public Node(int value, Node left, Node right){
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return this.left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return this.right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}

class BinrayTree{
	private Node root = null;

	public Node getRoot() {
		return this.root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	// 삽입
	public void insertNode(int value){
		if (root == null)
			setRoot(new Node(value));
		else {
			Node curNode = root;
			while(true){
				if (curNode.getValue() > value){
					if (curNode.getLeft() == null){
						curNode.setLeft(new Node(value));
						break;
					}
					else
						curNode = curNode.getLeft();
				}
				else if (curNode.getValue() < value){
					if (curNode.getRight() == null){
						curNode.setRight(new Node(value));
						break;
					}
					else
						curNode = curNode.getRight();
				}
				else{
					System.out.println("중복된 값은 들어 올 수 없습니다.");
					break;
				}
			}
		}
	}
	// dfs 전위순회
	public void dfs(Node node){
		if (node != null){
			System.out.println(node.getValue() + " ");
			dfs(node.getLeft());
			dfs(node.getRight());
		}
	}
	// bfs 탐색
	public void bfs(Node node){
		Queue<Node> queue = new LinkedList<Node>();

		Node seachNode = root;

		queue.add(seachNode);
		while(!queue.isEmpty()){
			Node curNode = queue.poll();

			if (curNode == null){
				System.out.println("찾으려는 데이터가 없습니다.");
				break;
			} 
			else if (curNode.getValue() == node.getValue()){
				System.out.println(curNode.getValue());
				break;
			}
			else
				System.out.println(curNode.getValue());
			
			if (curNode.getLeft() != null)
				queue.add(curNode.getLeft());
			if (curNode.getRight() != null)
				queue.add(curNode.getRight());
		}
	}
	// 삭제 (미완성)
	public void deleteNode(int value){
		if (root == null){
			System.out.println("이진트리가 존재하지 않습니다.");
		}
		else{
			Node curNode = root;
			Node prevNode = null;

			while(true){
				// 노드가 존재하지 않는 경우
				if (curNode.getValue() > value){
					if (curNode.getLeft() == null){
						System.out.println("삭제할 값이 존재 하지 않습니다.");
						break;
					}
					else{
						prevNode = curNode;
						curNode = prevNode.getLeft();
					}
				}
				else if (curNode.getValue() < value){
					if (curNode.getRight() == null){
						System.out.println("삭제할 값이 존재 하지 않습니다.");
						break;
					}
					else{
						prevNode = curNode;
						curNode = prevNode.getRight();
					}
				}
				else
					break;
			}
			
			// 삭제 할 노드, 삭제할 부모 노드
			// 자식이 없는 경우
			if (curNode.getLeft() == null && curNode.getRight() == null){
				if (prevNode.getValue() > curNode.getValue())
					prevNode.setLeft(null);
				else
					prevNode.setRight(null);
			}
			// 자식이 두개
			else if(curNode.getLeft() != null && curNode.getRight() != null){
				// 오른쪽 자신 중에 가장 작은 값
				Node targetNode = curNode.getRight();
				while(true){
					if (targetNode.getLeft() == null)
						break;
					prevNode = targetNode;
					targetNode = targetNode.getLeft();
				}
				curNode.setValue(targetNode.getValue());
				// 자식이 0개
				if (targetNode.getLeft() == null && targetNode.getRight() == null){
					prevNode.setRight(null);
					targetNode = null;
				}
				// 자식 한개
				else if (targetNode.getLeft() != null || targetNode.getRight() != null){
					if (targetNode.getLeft() != null)
						curNode.setLeft(targetNode.getLeft());
					else
						curNode.setRight(targetNode.getRight());
					targetNode = null;
				}
			}
			// 자식이 한개
			else{
				if (curNode.getLeft() != null){
					curNode.setValue(curNode.getLeft().getValue());
					curNode.setLeft(null);
				}
				else{
					curNode.setValue(curNode.getRight().getValue());
					curNode.setRight(null);
				}
			}
		}
	}
}
class exercise {
	// 트리 생성
	public static void main(String[] args) {
		BinrayTree tree = new BinrayTree();
		/*
		tree.insertNode(12);
		tree.insertNode(5);
		tree.insertNode(15);
		tree.insertNode(3);
		tree.insertNode(1);
		tree.insertNode(13);
		tree.insertNode(14);
		tree.insertNode(17);
		tree.insertNode(19);
		tree.insertNode(18);
		*/

		// https://mattlee.tistory.com/30
		tree.insertNode(35);
		tree.insertNode(18);
		tree.insertNode(7);
		tree.insertNode(3);
		tree.insertNode(12);
		tree.insertNode(26);
		tree.insertNode(22);
		tree.insertNode(30);
		tree.insertNode(68);
		tree.insertNode(99);

		/*
		System.out.println("before leaf node delete");
		tree.dfs(tree.getRoot());
		tree.deleteNode(30);
		System.out.println("after leaf nodedelete");
		tree.dfs(tree.getRoot());
		tree.insertNode(30);

		System.out.println("before one child delete");
		tree.dfs(tree.getRoot());
		tree.deleteNode(68);
		System.out.println("after one child delete");
		tree.dfs(tree.getRoot());
		tree.insertNode(68);

		System.out.println("before two child delete");
		tree.dfs(tree.getRoot());
		tree.deleteNode(18);
		System.out.println("after two child delete");
		tree.dfs(tree.getRoot());
		*/
		/*
			bfs test
			Node finNode = new Node(12);
			tree.bfs(finNode);
		*/
	}
}

// https://blog.naver.com/swoh1227/222175350122

public class Infix {
	Stack stack;
	Queue queue;
	String expression;

	public Infix(String expression) {
		stack = new ListStack();
		queue = new ListQueue();
		this.expression = expression;
	}

	public Postfix toPostfix() throws EmptyStackException {
		Postfix post = new Postfix(this.expression);
		for (int i = 0; i < post.expression.length(); i++) {
			Object Value = post.expression.charAt(i);
			Character charValue = (Character) Value;
			int intValue = (int) charValue;

			if (intValue >= 97 && intValue <= 122) {
				post.queue.enqueue(Value);
			} else if (charValue == '(' || checker(charValue) > -1) {
				if (post.stack.isEmpty() || (Character) post.stack.peek() == '(') {
					post.stack.push(Value);
				} else if (charValue == '(') {
					post.stack.push(Value);
				} else {
					while (!post.stack.isEmpty() && !((Character) post.stack.peek() == '(')
							&& (checker(charValue) <= checker((Character) post.stack.peek()))) {
						post.queue.enqueue(post.stack.pop());
					}

					post.stack.push(Value);
				}
			} else if (charValue == ')') {
				while ((Character) post.stack.peek() != '(') {
					post.queue.enqueue(post.stack.pop());
				}
				post.stack.pop();
			}
		}

		while (!post.stack.isEmpty()) {
			if (checker((Character) post.stack.peek()) > -1) {
				post.queue.enqueue(post.stack.pop());
			} else {
				post.stack.pop();
			}
		}

		return post;
	}

	public int checker(char a) {
		switch (a) {
		case '+':
			return 0;
		case '-':
			return 0;
		case '*':
			return 1;
		case '/':
			return 1;
		case '^':
			return 2;
		default:
			return -1;
		// throw new IllegalArgumentException("unkown expression" + a);
		}
	}
}

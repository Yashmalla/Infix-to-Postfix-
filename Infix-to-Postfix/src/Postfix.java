public class Postfix {
	Stack stack;
	Queue queue;
	String expression;

	public Postfix(String expression) {
		this.expression = expression;
		stack = new ListStack();
		queue = new ListQueue();
	}

	public double evaluate(List operands) throws EmptyQueueException, EmptyStackException {
		int size = queue.getSize();
		Character postfixValue = null;
		for (int i = 0; i < size - 1; i++) {
			postfixValue = (Character) queue.dequeue();
			System.out.print(postfixValue);

			if (checker(postfixValue) > -1) {

				double result = actionPerformer((double) stack.pop(), (double) stack.pop(), postfixValue);
				stack.push(result);
			} else {
				int j = 0;
				Operand op = (Operand) operands.get(j);
				while (!(postfixValue == op.getVariable().charAt(0))) {
					++j;
					op = (Operand) operands.get(j);
				}
				stack.push(op.getValue());
			}
		}
		postfixValue = (Character) queue.peek();
		System.out.print(postfixValue);
		System.out.println();
		return actionPerformer((double) stack.pop(), (double) stack.pop(), postfixValue);

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
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		// throw new IllegalArgumentException("unkown expression" + a);
		}
	}

	public double actionPerformer(double num2, double num1, char operator) {
		switch (operator) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			return num1 / num2;
		default:
			throw new IllegalArgumentException("The operator is not valid");
		}
	}
}

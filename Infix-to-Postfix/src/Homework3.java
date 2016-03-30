import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Homework3 {

	public static void main(String[] args) throws IOException, EmptyStackException, EmptyQueueException {
		run("src/infix.dat", "src/value.dat");
	}

	public static void run(String infixFile, String operandFile)
			throws EmptyStackException, EmptyQueueException, FileNotFoundException {
		Scanner infixInput = new Scanner(new File(infixFile));
		Scanner operandInput = new Scanner(new File(operandFile));
		List operands = new LinkedList();
		String format = "%-5s%s%n";
		System.out.println("Operands :");
		while (operandInput.hasNextLine()) {
			String line = operandInput.nextLine();
			String operandOperator[] = line.split(" ");
			String variable = operandOperator[0].toLowerCase();
			double value = Double.valueOf(operandOperator[1]);
			Operand o = new Operand();
			o.setVariable(variable);
			o.setValue(value);
			System.out.printf(format,o.getVariable(), o.getValue());
			operands.insertBack(o);
		}
		System.out.println();
		while (infixInput.hasNextLine()) {
			String line = infixInput.nextLine();
			String lineString = line.replaceAll("\\s", "").toLowerCase();
			System.out.println("Infix - " + line);
			Infix infix = new Infix(lineString);
			Postfix postfix = infix.toPostfix();
			System.out.print("Postfix - ");
			double result = postfix.evaluate(operands);
			System.out.println("The result of evaluation" + result);
			System.out.println();
		}

	}

}

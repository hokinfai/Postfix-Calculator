import java.util.Arrays;

public class ArrayStack {
	private String[] stack = new String[0];
	private int noOfItem = 0;

	public void push(String item) {
		if (noOfItem == stack.length) {
			int stackSize = (noOfItem == 0) ? 4 : noOfItem * 2;
			String[] newStack = Arrays.copyOf(stack, stackSize);
			stack = newStack;
		}
		if (item.equals("*")) {
			noOfItem--;
			double item1 = Double.parseDouble(pop());
			double item2 = Double.parseDouble(pop());
			double output = item1 * item2;
			noOfItem++;
			push("" + output);
		} else if (item.equals("+")) {
			noOfItem--;
			double item1 = Double.parseDouble(pop());
			double item2 = Double.parseDouble(pop());
			double output = item1 + item2;
			noOfItem++;
			push("" + output);
		} else if (item.equals("-")) {
			noOfItem--;
			double item1 = Double.parseDouble(pop());
			double item2 = Double.parseDouble(pop());
			double output = item2 - item1;
			noOfItem++;
			push("" + output);
		} else if (item.equals("/")) {
			noOfItem--;
			double item1 = Double.parseDouble(pop());
			double item2 = Double.parseDouble(pop());
			double output = item2 / item1;
			noOfItem++;
			push("" + output);
		} else {
			stack[noOfItem] = item;
			noOfItem++;
		}

	}

	public String pop() {
		if (stack.length == 0)
			return null;
		else {
			String output = stack[noOfItem];
			noOfItem--;
			// stack[noOfItem] = null;
			return output;
		}
	}

	public void getStack() {
		for (int i = 0; i < noOfItem; i++) {
			System.out.println(stack[i]);
		}

	}

	public static void main(String args[]) {
		ArrayStack stack = new ArrayStack();
		stack.push("5.0");
		stack.push("4.0");
		stack.push("-");
		stack.push("3.0");
		stack.push("-");
		stack.push("4.0");
		stack.push("-");
		stack.push("45.0");
		stack.push("84.0");
		stack.push("*");
		stack.push("+");
		stack.push("3");
		stack.push("+");
		// stack.calculator();
		stack.getStack();
	}
}

public class ExpressionEvaluator {
    public static void main (String[] args) {
        CustomizedStack stack = new CustomizedStack();
        int firstPop, secondPop;
        boolean isInt;
        
        for (int i = 0; i < args.length; i++) {
        	try {
            	Integer.parseInt(args[i]);
            	isInt = true;
        	}
        	catch (Exception e) {
            	isInt = false;
        	}
            if (isInt) {
                stack.push(Integer.parseInt(args[i]));
            } else if (args[i].equals("+")) {
                firstPop = stack.pop();
                secondPop = stack.pop();
                stack.push(secondPop + firstPop);
            } else if (args[i].equals("-")) {
                firstPop = stack.pop();
                secondPop = stack.pop();
                stack.push(secondPop - firstPop);
            } else if (args[i].equals("x")) {
                firstPop = stack.pop();
                secondPop = stack.pop();
                stack.push(secondPop * firstPop);
            } else if (args[i].equals("/")) {
                firstPop = stack.pop();
                secondPop = stack.pop();
                stack.push(secondPop / firstPop);
            } else if (args[i].equals("%")) {
                firstPop = stack.pop();
                secondPop = stack.pop();
                stack.push(secondPop % firstPop);
            } else {
                throw new IllegalArgumentException();
            }
        }
        System.out.println(stack.pop());
    }
}
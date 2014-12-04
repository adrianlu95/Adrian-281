public class CustomizedStack {
    private CustomizedNode top;
    private int length;

    public CustomizedStack () {
        this.top = null;
        this.length = 0;
    }
    
    public int pop () {
        int result = this.top.value;
        this.top = this.top.next;
        this.length--;
        return result;
    }

    public void push (int input) {
        CustomizedNode help = new CustomizedNode(input);
        help.next = top;
        this.top = help;
        this.length++;
    }
}
import java.util.ArrayList;
import java.lang.Character;
import java.util.Collections;

public class WordSort{
	public static void main(String[] args) throws Exception{
		java.io.BufferedReader stdIn = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String line = stdIn.readLine();
		ArrayList <String> input = new ArrayList<String>();
		ArrayList <String> output = new ArrayList<String>();
		while (line != null){
			input.add(line);
			line = stdIn.readLine();
		}
		int start;
		int end;
		for(int l = 0; l < input.size(); l++){
			start = 0;
			for(end = start; end < input.get(l).length(); end++){
				if(!Character.isLetter(input.get(l).charAt(end))){
					if(start < end){
						output.add(input.get(l).substring(start, end).toUpperCase());
					}
					start = end + 1;
				}
				else if(end == input.get(l).length() - 1){
					end++;
					output.add(input.get(l).substring(start, end).toUpperCase());
				}
			}
		}
		Collections.sort(output);
		int counter = 1;
		for(int l = 0; l < output.size() - 1; l++){
			if(output.get(l).equals(output.get(l + 1))){
				counter++;
			}
			else{
				System.out.println(output.get(l) + " " + counter);
				counter = 1;
			}
		}
		System.out.println(output.get(output.size() - 1) + " " + counter);	
	}
}
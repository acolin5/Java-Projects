// CSUN FALL 22   COMP182  Homework-3// Java Infix to Postfix Project Colinpostfix.javaimport java.io.*; import java.util.*; import java.util.Scanner; public class Colinhw3{	PrintStream prt = System.out;		// find priority of char ch    private int priority(char ch){    {      if(ch == '^') // power has the highest precedence      return 3;      else if(ch == '*' || ch == '/' || ch == '%') // next is *,/,and %      return 2;      return 1; // + and - has the lowest precedence     }  // end priority   }     // Convert infix exp to postfix      private String postfix(String exp){ // Complete this method Copy code from Lecture.         Stack <Character> stk = new Stack <Character>(); //error: type Stack does not take parameters		int j, n;			char ch;       n = exp.length();       exp = exp.toUpperCase();       String post = "";       for (j=0; j<n; j++){         ch = exp.charAt(j);          if (Character.isLetter(ch))            post += ch;          else if (ch == '(')            stk.push(ch);           else if (ch == ')'){              while (!stk.empty() && stk.peek() != '('){               post += stk.pop();               }              if (stk.empty()|| stk.peek() != '('){                  post = "invalid expression";                  return post; //exit                  }//end if                   else                     stk.pop();                  }                  else                  if (ch == '+' || ch =='-' || ch=='*'|| ch=='/' || ch=='%' || ch=='^'){                  while (!stk.empty() && stk.peek()!= '(' && priority(stk.peek()) >= priority(ch)){                        //if (stk.peek() == '('){                        //post = "invalid expression";                        //return post;                         //}                         post += stk.pop();                       }                        stk.push(ch);                      }                      else                       post +=ch;                      }                     while (!stk.empty()){                        if (stk.peek() == '(') {                        post = "invalid expression";                        return post;                         }                        post += stk.pop();                        }                        return post;                        } //end postfix                                                                 	// Your process method should be as follow:	// read infix and convert to postfix	private void process(String fn){ 	 //infix and postfix expressions are String	     String exp, post;     int j, n; // no. of infix input	     try{	    Scanner inf = new Scanner(new File(fn)); 		// read no. of expressions		n = inf.nextInt();					  prt.printf("\nn: %d", n); 		// Read input from any data file 		for (j = 1; j <= n; j++){		  // read next infix xpression						  exp = inf.next();		  //prt.printf("\nn: %s", exp); 		  // call infix to postfix method		  post = postfix(exp);		  prt.printf("\nPosfix of %s is: %s", exp, post); 		}// end for		inf.close();// close input file	 }catch (Exception e) {prt.printf("\nException " + e + "\n");}	}// end process method	    public static void main (String[] args){ 		// declare local variables		int cnt = args.length; // get no. of atguments		String fname;				// get no. of  arguments		cnt = args.length;		if (cnt < 1){			System.out.printf("\n\n\tOOPS Invalid No. of aguments! EXIT.\n");			return;		} // end if				// create an instance of postfix  		Colinhw3 tst = new Colinhw3();		// get input file name		fname = args[0];				System.out.printf("\n\n\n  fname: %s", fname);				// Call process to convert infix exp to postfix		tst.process(fname);  //MAKE SURE TO WRITE YOUR NAME IN NEXT LINE				//System.out.printf("\n\tAuthor: A. Colin Date: " + java.time.LocalDate.now());      	System.out.printf("\n\n\tAuthor: A. Colin Date: %s\n",		java.time.LocalDate.now());  	    } // end main} // end Colinpostfix
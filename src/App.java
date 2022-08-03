import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class App {
    // Options
    public  static void  showMenu(){
        String[] options = {"1- ||----Add new Word()------||",
                            "2- ||-----Delete Word()----- ||",
                            "3- ||-----Get Meaning()----- ||",
                            "4- ||-----Print Dict()------ ||",
                            "5- ||-----Spell-Check File---||",
                            "6- ||-----Exit Menu()--------||"
        };
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }


   
    public static void main(String[] args) throws Exception {
        
        // File path is passed as parameter
        File file = new File("wordList.txt");

      
        BufferedReader br = new BufferedReader(new FileReader(file));

        // create Dictionary
        Dictionary d = new Dictionary();

        // initalize array to hold words from txt file
        String arr[] = new String[1001];
        int n = 0;

        // Declaring a string variable
        String strWord;
        while ((strWord = br.readLine()) != null){
            // add word to array
            arr[n] = strWord;
            n++;

        }
        br.close();

        // convert sorted array to BST
        System.out.println("Preorder traversal of constructed BST");
        d.sortedArrayToBST(arr, 0, n - 1);
        

        // check if tree is balanced
        if (d.isBalanced(d.root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    

        
        Scanner scanner = new Scanner(System.in);
        Console cnsl = System.console();
        
       String opt;
       int option;
       boolean exit = true;

        while (exit){
                do
                {
                    showMenu();
                     opt  = scanner.nextLine();
                }
                 while (!(opt.matches("[1-6]+") && opt.length() > 0));
                 option = Integer.parseInt(opt);

                 

                switch(option){
                 case 1: 
                    String word = cnsl.readLine("Enter new word: ");
                    String meaning = cnsl.readLine("Enter meaning: ");
                    if(d.add(word, meaning)){
                        System.out.println(word + " has beena added to dictionary!");
                    }else{
                        System.out.println("word already exists!");
                 }
                 break;
                 case 2:
                    word = cnsl.readLine("Enter word to delete: ");
                    if (d.delete(word)){
                        System.out.println(word + " has been deleted from dictionary!");
                    }else{
                        System.out.println(word + " does not exist in dictionary!");
                    }
                 break;
                 case 3:
                    word = cnsl.readLine("Enter word: ");
                    System.out.println(d.getMeaning(word));
                 break;
                 case 4: 
                    d.printDictionary();
                 break;
                 case 5:
                    System.out.print("Enter filename(Full Path): ");
                    String filename = cnsl.readLine();
                    File InputFile = new File(filename);
                    br = new BufferedReader(new FileReader(InputFile)); 
                    String str;
                    int index = 0;
                    String newArr[] = new String[1000];
                    while( (str = br.readLine()) != null)    
                     {
                        String[] words = str.split("\\s+");
                        for (int i = 0; i < words.length; i++) {
                    
                            words[i] = words[i].replaceAll("[^\\w]", "");
                            // if condition filters existing words from addling to array!
                            if(!d.exists(words[i].toLowerCase())){
                                newArr[index] = words[i];
                                index++;
                            }
                        }   
                    }
                     System.out.println("words in dictionary have been  filtered from  file :" + filename );
                     System.out.println("----------------------------------" );
                    System.out.println("List of words:" );
                    for(int i = 0; i< index;i++){
                        System.out.println(newArr[i]);
                    }
                    System.out.println("----------------------------------" );
                System.in.read();
                break;
                case 6:
                exit = false;
                break;
            }

            System.out.println("Press Any key to Continue!");
            System.in.read();
        }

    }
           
        
}

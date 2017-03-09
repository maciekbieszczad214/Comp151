package Lab06;

import java.util.*;

/**
 * This class creates all permutations of the given string
 *
 * @author Maciek Bieszczad
 * @version 2/24/2017
 */
public class UniqueAnagrams
{
    private ArrayList<String> anagrams;

    public UniqueAnagrams()
    {
        this.anagrams = new ArrayList<>();
    }

    public void permutations(String word)
    {
        permutations("", word);
        System.out.println("Possible anagrams = " + this.anagrams);

        TreeSet<String> toTest = new TreeSet(this.anagrams);
        System.out.println("Expected unique and sorted anagrams = " + toTest);
        System.out.println();

        sort(); // duplicates will be removed during the sorting process
    }

    private void permutations(String prefix, String suffix)
    {
        int numOfChars = suffix.length();
        if (numOfChars == 1)
        {
            this.anagrams.add(prefix + suffix);
        }
        else
        {
            //TODO Project2 done
            for (int i = 0; i < suffix.length(); i++) {
                String current = suffix.substring(i, i + 1);
                String before = suffix.substring(0, i);
                String after = suffix.substring(i + 1);
                permutations(prefix + current, before + after);
            }
        }
    }

    private void sort()
    {
        //TODO Project2 done

        // calls getIndexOfSmallestAndRemoveDuplicates(index, this.anagrams.size());
        // calls swap(index, indexOfNextSmallest);

        for (int index = 0; index < anagrams.size() - 1; index++) {
            int indexOfNextSmallest = getIndexOfSmallestAndRemoveDuplicates(index, anagrams.size() - 1);
            swap(index, indexOfNextSmallest);
        }
    }

    private int getIndexOfSmallestAndRemoveDuplicates(int first, int last)
    {
        //TODO Project2 done

        // as the smallest is being found removes duplicates

        String min = anagrams.get(first);
        int indexOfMin = first;
        for (int index = first + 1; index <= last; index++) {
            int diff = anagrams.get(index).compareTo(min);
            if (diff < 0) {
                min = anagrams.get(index);
                indexOfMin = index;
            } else if (diff == 0) {
                anagrams.remove(index);
                index--;
                last--;
            }
        }
        return indexOfMin;
    }

    private void swap(int i, int j)
    {
        //TODO Project2 done
        if (i != j) {
            String temp = anagrams.get(i);
            anagrams.set(i, anagrams.get(j));
            anagrams.set(j, temp);
        }
    }

    private void display()
    {
        System.out.println("Computed unique and sorted anagrams = " + this.anagrams);
    }

    public static void main(String[] args)
    {
        UniqueAnagrams uniqueAnagrams = new UniqueAnagrams();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter a word");
        String word = keyboard.next();

        uniqueAnagrams.permutations(word);
        uniqueAnagrams.display();
    }
}

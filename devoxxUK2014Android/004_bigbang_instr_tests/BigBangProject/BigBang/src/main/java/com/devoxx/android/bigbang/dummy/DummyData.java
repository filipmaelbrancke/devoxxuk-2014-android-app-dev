package com.devoxx.android.bigbang.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.devoxx.android.bigbang.R;

/**
 * Helper class for providing sample content
 */
public class DummyData {

    /**
     * An array of sample persons.
     */
    public static List<BigBangCharacter> PERSONS = new ArrayList<BigBangCharacter>();

    /**
     * A map of sample persons, by ID.
     */
    public static Map<String, BigBangCharacter> PERSON_MAP = new HashMap<String, BigBangCharacter>();

    static {
        // Add the Big Bang characters.
        addItem(new BigBangCharacter(UUID.randomUUID().toString(), "Sheldon", "Cooper", "Jim Parsons", "Theoretical physicist", "Sheldon Lee Cooper, M.A., Ph.D., Sc.D. is a fictional character on the CBS television series The Big Bang Theory, portrayed by actor Jim Parsons. For his portrayal, Parsons has won two Primetime Emmy Awards, a Golden Globe Award, a TCA Award, and a Critics' Choice Television Award.\n" +
                "Sheldon is a Caltech theoretical physicist who shares an apartment with his colleague and best friend, Leonard Hofstadter (Johnny Galecki). Sheldon exhibits a strict adherence to routine, a total lack of social skills, a tenuous understanding of irony, sarcasm, and humor, and a general lack of humility or empathy. He is vocal about his own superior intellect compared to all around him. These characteristics provide the majority of the humor involving him, which has caused him to be described as the show's breakout character. Despite speculation that Sheldon's personality traits may be consistent with Asperger syndrome, obsessive–compulsive personality disorder and asexuality; co-creator Bill Prady has repeatedly stated that Sheldon's character was not conceived nor developed with regard to any of these conditions.", null, R.drawable.sheldon_cooper));
        addItem(new BigBangCharacter(UUID.randomUUID().toString(), "Leonard", "HofStadter", "Johnny Galecki", "Experimental physicist", "Leonard Leakey Hofstadter, Ph.D., is a fictional character on the CBS television series The Big Bang Theory, portrayed by actor Johnny Galecki. Leonard is an experimental physicist originally from New Jersey who shares an apartment with colleague and friend Dr. Sheldon Cooper (Jim Parsons). Leonard and Sheldon are named after actor/producer Sheldon Leonard, and Nobel Prize Laureates Robert Hofstadter and Leon Cooper.\n" +
                "Leonard has been described as the straight man of the series. Penny (Kaley Cuoco) is Leonard's next-door neighbor and main love interest, and the teasing of romance between the two of them is a major force driving the series. For his portrayal, Galecki was nominated for a Primetime Emmy Award and a Golden Globe Award.", "http://en.wikipedia.org/wiki/Johnny_Galecki", R.drawable.leonard_hofstadter));
        addItem(new BigBangCharacter(UUID.randomUUID().toString(), "Howard", "Wolowitz", "Simon Helberg", "Aerospace engineer", "Howard Joel Wolowitz, M.Eng is a fictional character on the CBS television series The Big Bang Theory, portrayed by actor Simon Helberg. Among the main male characters in the show, Howard is distinguished for lacking a doctoral degree, for still living with his mother, and for believing himself to be a \"ladies' man\". Simon Helberg's character is named after a computer programmer known by the show's co-creator Bill Prady.", null, R.drawable.howard_wolowitz));
        addItem(new BigBangCharacter(UUID.randomUUID().toString(), "Rajesh", "Koothrappali", "Kunal Nayyar", "Particle astrophysicist", "Rajesh Ramayan \"Raj\" Koothrappali, Ph.D. (born October 6[2]) is a fictional character on the CBS television series The Big Bang Theory, portrayed by actor Kunal Nayyar.\n" +
                "Rajesh is Howard Wolowitz's (Simon Helberg) best friend, which Kunal Nayyar calls a bromance. The relationship has also been described by Leonard's mother, Dr. Beverly Hofstadter, (Christine Baranski) as an \"ersatz homosexual marriage.\" Raj works as an astrophysicist in the Physics Department at Caltech. His principal characteristic is selective mutism which does not allow him to talk to women (outside of his family) unless under the influence of alcohol or believing that he consumed alcohol.", null, R.drawable.rajesh_koothrappali));
        addItem(new BigBangCharacter(UUID.randomUUID().toString(), "Penny", "", "Kaley Cuoco", "Waitress", "Penny is a fictional character on the CBS television series The Big Bang Theory, portrayed by American actress Kaley Cuoco.\n" +
                "Penny is the primary female character on the show, befriending her across-the-hall neighbors Leonard Hofstadter (Johnny Galecki) and Sheldon Cooper (Jim Parsons), two physicists who work at the nearby California Institute of Technology (CalTech). Penny's lack of advanced education but outgoing personality and common sense drastically contrast with the personalities of the primary male characters in the series, even though she is considered part of their group. She is the love interest of Leonard, whom she dates regularly during the third, fifth and sixth seasons.", null, R.drawable.penny));
    }

    private static void addItem(BigBangCharacter item) {
        PERSONS.add(item);
        PERSON_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class BigBangCharacter {
        public String id;
        public String name;
        public String lastName;
        public String realName;
        public String profession;
        public String bio;
        public String url;
        public int imageResource;

        public BigBangCharacter(String id, String name, String lastName, String realName, String profession, String bio, String url, int imageResource) {
            this.id = id;
            this.name = name;
            this.lastName = lastName;
            this.realName = realName;
            this.profession = profession;
            this.bio = bio;
            this.url = url;
            this.imageResource = imageResource;
        }

        @Override
        public String toString() {
            return name + " " + lastName;
        }
    }
}

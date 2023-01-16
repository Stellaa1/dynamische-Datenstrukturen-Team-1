package de.hebk;
import de.hebk.model.list.List;
public class Fragen {
    private List<Question> questions = new List<>();
    GameSettings gameSettings = new GameSettings();
    public List<Question> getQuestions(){
        return questions;
    }
    public void generateQuestions(){
        CSVReader csvReader = new CSVReader();
        List<String> f = csvReader.read_List_String("doku/Fragen/" + gameSettings.getCategory() + ".csv",0);
        List<String> d = csvReader.read_List_String("doku/Fragen/" + gameSettings.getCategory() + ".csv",1);
        List<String> r = csvReader.read_List_String("doku/Fragen/" + gameSettings.getCategory() + ".csv",2);
        List<String> o2 = csvReader.read_List_String("doku/Fragen/" + gameSettings.getCategory() + ".csv",3);
        List<String> o3 = csvReader.read_List_String("doku/Fragen/" + gameSettings.getCategory() + ".csv",4);
        List<String> o4 = csvReader.read_List_String("doku/Fragen/" + gameSettings.getCategory() + ".csv",5);
            for (int i = 1; i < f.size() + 1; i++){
                try {
                d.get(i).setContext(d.get(i).getContext().replaceAll("\\D+", "1000"));
                if (Integer.parseInt(d.get(i).getContext()) <= gameSettings.getDifficultyValue() && Integer.parseInt(d.get(i).getContext()) >= gameSettings.getDifficultyRange()){
                    gameSettings.setDifficultyValue(gameSettings.getDifficultyValue() + gameSettings.getIncrementValue());
                    gameSettings.setDifficultyRange(gameSettings.getDifficultyRange() + gameSettings.getIncrementRange());
                    Question q = new Question();
                    q.setQuestion(f.get(i).getContext().replaceAll("<K>", ","));
                    q.setDifficulty((byte) Integer.parseInt(d.get(i).getContext()));
                    q.setOptions(new List<>());
                    q.getOptions().append(r.get(i).getContext());
                    q.getOptions().append(o2.get(i).getContext());
                    q.getOptions().append(o3.get(i).getContext());
                    q.getOptions().append(o4.get(i).getContext());
                    questions.append(q);
                    int x = (int) (Math.random() * 100);
                    if (x <= 7){
                        int z = (int) (Math.random() * 3);
                        q.getOptions().get(z).setContext("Keine von genannten");
                    }
                    if (gameSettings.getDifficultyRange() >= gameSettings.getDifficultyValue()){
                        gameSettings.setDifficultyRange(gameSettings.getDifficultyValue() - 1);
                    }
                }
                } catch (Exception e){
                    continue;
            }
        }

        //questions.random();
        List<Question> questions2 = new List<>();
        System.out.println(questions.size() + " questions size");
        int x = 0;
        int i = 0;
        int s = questions.size();
        List<Integer> foundIndecies = new List<>();
        while (i < questions.size()){
            if (questions2.size() >= gameSettings.getQuestion_Amount()){
                break;
            }
            x = (int) (Math.random() * s);
            if (!foundIndecies.find(x)){
                questions2.append(questions.get(x).getContext());
                foundIndecies.append(x);
                i++;
            }
        }
        questions = questions2;
    }
}
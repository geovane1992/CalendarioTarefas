package Controller;

import Model.Aluno;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eric
 */
public class LeitorCSV {

    public List lerListaAlunos(String arquivo) {
        BufferedReader reader = null;
        String linha = "";
        String separador = ",";
        List<Aluno> listaAlunos = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(arquivo));
            while ((linha = reader.readLine()) != null) {
                String[] linhaAluno = linha.split(separador);
                Aluno aluno = new Aluno();
                aluno.setMatricula(Integer.parseInt(linhaAluno[0]));
                aluno.setNome(linhaAluno[1]);
                aluno.setEmail(linhaAluno[2]);
                aluno.setCodDisciplina(Integer.parseInt(linhaAluno[3]));
                aluno.setCodTurma(Integer.parseInt(linhaAluno[4]));

                listaAlunos.add(aluno);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return listaAlunos;
    }
}

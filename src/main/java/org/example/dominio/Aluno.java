package org.example.dominio;


import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
@Data

public class Aluno {

    private String nome;
    private String matricula;
    private LocalDate dataNascimento;

    private List<InscricaoCurso> inscricaoCursoList;


    public String apresentar() {
        // LocalDate.now().getYear() - dataNascimento.getYear(),
        return String.format("Aluno: %s  de matricula %s com data de nascimento %s (%d anos)," +
                        "%n \t Cursos %n %s",
                this.getNome(), this.getMatricula(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dataNascimento),
                Period.between(dataNascimento, LocalDate.now()).getYears(),
                getCurso());
    }

    private String getCurso() {
        StringBuilder builder = new StringBuilder();
        builder.append("Curso \t Data Inicio \t Data Termino \t Dias para começar o Curso \n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (InscricaoCurso objetoInscricaoCurso : inscricaoCursoList) {
            final LocalDate dataTermino = objetoInscricaoCurso.getDataInicioDoCurso().
                    plusMonths(objetoInscricaoCurso.getCurso().getDuraçao());
            builder.append(String.format("%s \t %s \t %s \t %d %n",
                    objetoInscricaoCurso.getCurso().getNome(),
                    formatter.format(objetoInscricaoCurso.getDataInicioDoCurso()),
                    formatter.format(dataTermino),
                   ChronoUnit.DAYS.between(LocalDate.now(), objetoInscricaoCurso.getDataInicioDoCurso())
            ));
        }
        //Posso usar as duas opções abaixo para imprimir o tanto de dias que falta pra começar o curso
        // Opção 1 - Duration.between(LocalDate.now().atStartOfDay(),
        //  objetoInscricaoCurso.getDataInicioDoCurso().atStartOfDay())
        //  .toDays()

        //Opção 2 - Period.between(LocalDate.now(),objetoInscricaoCurso.getDataInicioDoCurso()).getMonths()));

        /*for(int i =0;i<inscricaoCursoList.size();i++){
        InscricaoCurso objetoInscricaoCurso = inscricaoCursoList.get(i);}
         */

        return builder.toString();
    }

}


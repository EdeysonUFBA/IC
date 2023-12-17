package cs2013;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Gera a hierarquia (Lista) a colocar num HTML (HierarquiaBok2013.html).
 * @author edeys
 *
 */
public class FileToHTMLList {
    public static void main(String[] args) {
        // Defina o caminho para o arquivo de entrada
        String filePath = "BOK2013Hierarquia.txt";
        
        // Leitura do arquivo e criação da lista hierárquica
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
                //System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Processamento das linhas para criar a lista HTML
        StringBuilder htmlBuilder = new StringBuilder();
        int prevIndentation = 0;
        
        for (String line : lines) {

                int indentation = Integer.parseInt(line.substring(0, 1));
                String text = line.substring(1);
                
                if (indentation > prevIndentation) {
                    htmlBuilder.append("<ul>");
                } else if (indentation < prevIndentation) {
                    int diff = prevIndentation - indentation;
                    for (int i = 0; i < diff; i++) {
                        htmlBuilder.append("</ul>");
                    }
                }
                
                htmlBuilder.append("<li>").append(text).append("</li>");
                //System.out.println(text);
                
                prevIndentation = indentation;
        }
        
        // Feche todas as listas não fechadas
        for (int i = 0; i <= prevIndentation; i++) {
            htmlBuilder.append("</ul>");
        }
        
        // Crie um arquivo HTML de saída
        String htmlOutput = htmlBuilder.toString();
        System.out.println(htmlOutput);
    }
}


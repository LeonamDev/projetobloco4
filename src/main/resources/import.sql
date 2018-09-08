/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  leonam
 * Created: 08/09/2018
 */

INSERT INTO curso(codigo, nome) VALUES("ENGJAVA", "ENGENHERIA DE SOFTWARE COM JAVA");
INSERT INTO bloco(codigo, nome, curso_id) VALUES("JAVAWEB","JAVA WEB E SERVICOS",1);
INSERT INTO modulo(codigo, nome, bloco_id) VALUES ("SERVICOSJAVA", "SERVIÇOS COM TECNOLOGIA JAVA", 1);
INSERT INTO turma(periodo_fim, periodo_inicio, modulo_id) VALUES('2018-08-09', '2019-08-09', 1);
INSERT INTO pessoa(cpf,email, genero,nome) VALUES("14915623263","sistemadeavaliacaoinfnet@gmail.com", "M", "Steve Wozniak");  
INSERT INTO aluno(matricula, id, turma_id) VALUES("15326529", 1, 1);
insert into avaliacao(codigo_avaliacao,inicio_avaliacao,termino_avaliacao,turma_id) values("45ASD45A","2018-09-08 17:33:35.133", "2018-10-08 17:33:35.133", 1);



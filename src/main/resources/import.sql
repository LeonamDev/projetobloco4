INSERT INTO curso(codigo, nome) VALUES("ENGJAVA", "ENGENHERIA DE SOFTWARE COM JAVA");
INSERT INTO bloco(codigo, nome, curso_id) VALUES("JAVAWEB","JAVA WEB E SERVICOS",1);
INSERT INTO modulo(codigo, nome, bloco_id) VALUES ("SERVICOSJAVA", "SERVIÇOS COM TECNOLOGIA JAVA", 1);
INSERT INTO turma(periodo_fim, periodo_inicio, modulo_id) VALUES('2018-08-09', '2019-08-09', 1);

INSERT INTO pessoa(cpf,email, genero,nome) VALUES("29847771073","sistemadeavaliacaoinfnet2@gmail.com", "M", "Steve Wozniak");  
INSERT INTO pessoa(cpf,email, genero,nome) VALUES("34235111094","sistemadeavaliacaoinfnet@gmail.com", "M", "Atuharz Anfigal");  
INSERT INTO pessoa(cpf,email, genero,nome) VALUES("00219448060","sistemadeavaliacaoinfnet@gmail.com", "F", "Headan Bughfyeurn");  
INSERT INTO pessoa(cpf,email, genero,nome) VALUES("76305634009","sistemadeavaliacaoinfnet@gmail.com", "F", "Pifuadak Narhe");  
INSERT INTO pessoa(cpf,email, genero,nome) VALUES("41714464067","sistemadeavaliacaoinfnet@gmail.com", "M", "Olpaesgdub Xyoci");  
INSERT INTO pessoa(cpf,email, genero,nome) VALUES("00860412075","sistemadeavaliacaoinfnet@gmail.com", "M", "Mukgum Winou");  
INSERT INTO pessoa(cpf,email, genero,nome) VALUES("41570595062","sistemadeavaliacaoinfnet@gmail.com", "F", "Rigaborn Wervilli");  
INSERT INTO pessoa(cpf,email, genero,nome) VALUES("21873293054","sistemadeavaliacaoinfnet@gmail.com", "M", "Keoes Suamakh");  
INSERT INTO pessoa(cpf,email, genero,nome) VALUES("38601572057","sistemadeavaliacaoinfnet@gmail.com", "F", "Snatmoit Xuapu");  

INSERT INTO aluno(matricula, id, turma_id) VALUES("04819816", 1, 1);
INSERT INTO aluno(matricula, id, turma_id) VALUES("15326529", 2, 1);
INSERT INTO aluno(matricula, id, turma_id) VALUES("26646873", 3, 1);
INSERT INTO aluno(matricula, id, turma_id) VALUES("33922756", 4, 1);
INSERT INTO aluno(matricula, id, turma_id) VALUES("41876712", 5, 1);
INSERT INTO aluno(matricula, id, turma_id) VALUES("57776106", 6, 1);
INSERT INTO aluno(matricula, id, turma_id) VALUES("68159242", 7, 1);
INSERT INTO aluno(matricula, id, turma_id) VALUES("75676872", 8, 1);
INSERT INTO aluno(matricula, id, turma_id) VALUES("83734809", 9, 1);
INSERT INTO aluno(matricula, id, turma_id) VALUES("97403688", 10, 1);

INSERT INTO email_abertura(link_avaliacao, texto) VALUES("http://localhost:8084/avaliacao/respostaAvaliacao.xhtml","Segue o link para você realizar a avaliação");

INSERT INTO avaliacao(codigo_avaliacao,inicio_avaliacao,termino_avaliacao,turma_id, email_abertura_id, questionario_id) VALUES("15ASD45A","2018-05-08 17:33:35.133", "2018-10-08 17:33:35.133", 1, 1, 1);
INSERT INTO avaliacao(codigo_avaliacao,inicio_avaliacao,termino_avaliacao,turma_id, email_abertura_id, questionario_id) VALUES("25ASD45A","2018-06-08 17:33:35.133", "2018-10-08 17:33:35.133", 1, 1, 1);
INSERT INTO avaliacao(codigo_avaliacao,inicio_avaliacao,termino_avaliacao,turma_id, email_abertura_id, questionario_id) VALUES("35ASD45A","2018-07-08 17:33:35.133", "2018-10-08 17:33:35.133", 1, 1, 1);
INSERT INTO avaliacao(codigo_avaliacao,inicio_avaliacao,termino_avaliacao,turma_id, email_abertura_id, questionario_id) VALUES("45ASD45A","2018-08-08 17:33:35.133", "2018-10-08 17:33:35.133", 1, 1, 1);
INSERT INTO avaliacao(codigo_avaliacao,inicio_avaliacao,termino_avaliacao,turma_id, email_abertura_id, questionario_id) VALUES("55ASD45A","2018-09-08 17:33:35.133", "2018-10-08 17:33:35.133", 1, 1, 1);

INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_GERAL_POS_GRADUACAO", '2018-09-15', "1. O professor contribuiu para o meu aprendizado.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_GERAL_POS_GRADUACAO", '2018-09-15', "2. O professor é atencioso e esteve disponível para tirar dúvidas.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_GERAL_POS_GRADUACAO", '2018-09-15', "3. O professor aproveitou bem o tempo em sala de aula.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_GERAL_POS_GRADUACAO", '2018-09-15', "4. O professor utilizou o Moodle e outros recursos didáticos para ajudar nome");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_GERAL_POS_GRADUACAO", '2018-09-15', "5. O professor aproveitou bem os recursos da sala de aula.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_GERAL_POS_GRADUACAO", '2018-09-15', "6. Gostaria de cursar outros módulos com esse professor.");   
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_PROFESSOR_MODULO", '2018-09-15', "1. O professor contribuiu para o meu aprendizado.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_PROFESSOR_MODULO", '2018-09-15', "2. O professor é atencioso e esteve disponível para tirar dúvidas.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_PROFESSOR_MODULO", '2018-09-15', "3. O professor aproveitou bem o tempo em sala de aula.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_PROFESSOR_MODULO", '2018-09-15', "4. O professor utilizou o Moodle e outros recursos didáticos para ajudar no meu aprendizad");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_PROFESSOR_MODULO", '2018-09-15', "5. O professor aproveitou bem os recursos da sala de aula.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_PROFESSOR_MODULO", '2018-09-15', "6. Gostaria de cursar outros módulos com esse professor.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_CONTEUDO_INFRA_ESTRUTUTA_MODULO", '2018-09-15', "1. Eu adquiri as competências propostas para o módulo.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_CONTEUDO_INFRA_ESTRUTUTA_MODULO", '2018-09-15', "2. O módulo foi útil para o meu crescimento profissional.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_CONTEUDO_INFRA_ESTRUTUTA_MODULO", '2018-09-15', "3. A carga horária do módulo foi apropriada.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_CONTEUDO_INFRA_ESTRUTUTA_MODULO", '2018-09-15', "4. O acervo da biblioteca atendeu as necessidades desse módulo.");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_CONTEUDO_INFRA_ESTRUTUTA_MODULO", '2018-09-15', "5. A configuração do(s) computadore(s) e equipamentos da sala de aula e a qualidade do suporte foi apropriada.");

INSERT INTO questionario(identificador) VALUES("Avaliação - Alunos da Graduação");
INSERT INTO questionario(identificador) VALUES("Avaliação - Alunos da Pós-Graduação");
INSERT INTO questionario(identificador) VALUES("Avaliação - Alunos da Extensão");
INSERT INTO questionario(identificador) VALUES("Avaliação - Alunos do Politécnico");

INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 1);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 2);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 3);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 4);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 5);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 6);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 7);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 8);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 9);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 10);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 11);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 12);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 13);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 14);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 15);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 16);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 17);


INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("CONCORDO_TOTALMENTE", 2, 1, 1);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("CONCORDO_PARCIALMENTE", 2, 1, 2);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("NAO_CONCORDO_NEM_DISCORDO", 2, 1, 3);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("DISCORDO_PARCIALMENTE", 2, 1, 4);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("SEM_RESPOSTA", 2, 1, 5);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("CONCORDO_TOTALMENTE", 2, 1, 6);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("CONCORDO_PARCIALMENTE", 2, 1, 7);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("CONCORDO_PARCIALMENTE", 2, 1, 8);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("DISCORDO_TOTALMENTE", 2, 1, 9);

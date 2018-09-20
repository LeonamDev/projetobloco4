INSERT INTO curso(codigo, nome) VALUES("ENGJAVA", "ENGENHERIA DE SOFTWARE COM JAVA");
INSERT INTO bloco(codigo, nome, curso_id) VALUES("JAVAWEB","JAVA WEB E SERVICOS",1);
INSERT INTO modulo(codigo, nome, bloco_id) VALUES ("SERVICOSJAVA", "SERVIÇOS COM TECNOLOGIA JAVA", 1);
INSERT INTO turma(periodo_fim, periodo_inicio, modulo_id) VALUES('2018-08-09', '2019-08-09', 1);
INSERT INTO pessoa(cpf,email, genero,nome) VALUES("14915623263","sistemadeavaliacaoinfnet@gmail.com", "M", "Steve Wozniak");  
INSERT INTO aluno(matricula, id, turma_id) VALUES("15326529", 1, 1);
INSERT INTO email_abertura(link_avaliacao, texto) VALUES("http://localhost:8084/avaliacao/questionario","Segue o link para você realizar a avaliação");
INSERT INTO avaliacao(codigo_avaliacao,inicio_avaliacao,termino_avaliacao,turma_id, email_abertura_id) VALUES("45ASD45A","2018-09-08 17:33:35.133", "2018-10-08 17:33:35.133", 1, 1);

/***
 *Inserido para testes de desenvolvimento do cadastro de questões. - Comentar ou remover para apresentação.
 */
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

/***
 *Inserido para testes de desenvolvimento do cadastro de avaliação. - Comentar ou remover para apresentação.
 */
INSERT INTO questionario(identificador) VALUES("Avaliação - Alunos da Graduação");
INSERT INTO questionario(identificador) VALUES("Avaliação - Alunos da Pós-Graduação");
INSERT INTO questionario(identificador) VALUES("Avaliação - Alunos da Extensão");
INSERT INTO questionario(identificador) VALUES("Avaliação - Alunos do Politécnico");

INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_GERAL_POS_GRADUACAO", '2018-09-15', "Questao geral 1");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_GERAL_POS_GRADUACAO", '2018-09-15', "Questao geral 2");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_GERAL_POS_GRADUACAO", '2018-09-15', "Questao geral 3");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_PROFESSOR_MODULO", '2018-09-15', "Questao professor 1");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_PROFESSOR_MODULO", '2018-09-15', "Questao professor 2");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_PROFESSOR_MODULO", '2018-09-15', "Questao professor 3");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_CONTEUDO_INFRA_ESTRUTUTA_MODULO", '2018-09-15', "Questao infra 1");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_CONTEUDO_INFRA_ESTRUTUTA_MODULO", '2018-09-15', "Questao infra 2");
INSERT INTO questao(categoria, data_criacao, descricao) VALUES("AVALIACAO_CONTEUDO_INFRA_ESTRUTUTA_MODULO", '2018-09-15', "Questao infra 3");
INSERT INTO questionario(identificador) VALUES("TESTE01");

INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 1);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 2);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 3);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 4);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 5);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 6);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 7);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 8);
INSERT INTO questionario_questao(questionario_id, questao_id) VALUES(1, 9);

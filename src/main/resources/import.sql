INSERT INTO curso(codigo, nome) VALUES("ENGJAVA", "ENGENHERIA DE SOFTWARE COM JAVA");
INSERT INTO bloco(codigo, nome, curso_id) VALUES("JAVAWEB","JAVA WEB E SERVICOS",1);
INSERT INTO modulo(codigo, nome, bloco_id) VALUES ("SERVICOSJAVA", "SERVIÇOS COM TECNOLOGIA JAVA", 1);
INSERT INTO turma(periodo_fim, periodo_inicio, modulo_id) VALUES('2018-08-09', '2019-08-09', 1);
INSERT INTO pessoa(cpf,email, genero,nome) VALUES("14915623263","sistemadeavaliacaoinfnet@gmail.com", "M", "Steve Wozniak");  
INSERT INTO aluno(matricula, id, turma_id) VALUES("15326529", 1, 1);
INSERT INTO email_abertura(link_avaliacao, texto) VALUES("http://localhost:8084/avaliacao/questionario","Segue o link para você realizar a avaliação");
INSERT INTO avaliacao(codigo_avaliacao,inicio_avaliacao,termino_avaliacao,turma_id, email_abertura_id) VALUES("45ASD45A","2018-09-08 17:33:35.133", "2018-10-08 17:33:35.133", 1, 1);


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

-- Inserindo para testes de desenvolvimento dados da resposta de uma avaliação
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("CONCORDO_TOTALMENTE", 1, 1, 1);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("CONCORDO_PARCIALMENTE", 1, 1, 2);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("NAO_CONCORDO_NEM_DISCORDO", 1, 1, 3);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("DISCORDO_PARCIALMENTE", 1, 1, 4);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("SEM_RESPOSTA", 1, 1, 5);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("CONCORDO_TOTALMENTE", 1, 1, 6);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("CONCORDO_PARCIALMENTE", 1, 1, 7);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("CONCORDO_PARCIALMENTE", 1, 1, 8);
INSERT INTO resposta(grau_conformidade, aluno_id, avaliacao_id, questao_id) VALUES("DISCORDO_TOTALMENTE", 1, 1, 9);


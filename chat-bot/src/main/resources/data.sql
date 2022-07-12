INSERT INTO Chatbot_Yampi_Message_Models(message_models_id,text,sequence)
VALUES (1,'Olá, *<nome_cliente>* \uD83D\uDE04\nSou a assistente virtual da loja *<nome_loja>*.\uD83E\uDD16\nEm que posso ajudar?\uD83E\uDD14\n\n*Informe apenas o número da opção escolhida*\n\n;*1* - Rastrear Pedido \uD83D\uDE9A);*2* - Segunda Via do Boleto \uD83D\uDCE5\n*3* - Quero trocar a cor ou tamanho\n*4* - Prazo de entrega\n*5* - Cancelamento do pedido\n*6* - Produto com defeito\n*7* - Atraso do pedido\n*8* - Dúvidas sobre produto',0);
INSERT INTO Chatbot_Yampi_Message_Models(message_models_id,text,sequence)
VALUES (2,'Me informe o *CPF* utilizado no momento da compra para encontrarmos seu pedido.\n\n\uD83D\uDC49\uD83C\uDFFB  Me envie apenas os 11 dígitos do seu CPF *(ex.: 01234567890)*.',1);
INSERT INTO Chatbot_Yampi_Message_Models(message_models_id,text,sequence)
VALUES (3,'*Não encontramos o CPF em nossa loja*.\n\n\uD83D\uDC49\uD83C\uDFFB  Por favor, verifique se o CPF está digitado corretamente ou é o CPF utilizado na compra do pedido.',2);
INSERT INTO Yampi (yampi_id,alias,token,secret_key) VALUES (1,'divina-store','c85193288641a83cabab92cc29eb814a9466c242','c85193288641a83cabab92cc29eb814a9466c242');
INSERT INTO Whatsapp (whatsapp_id,yampi_id,number,integration,name) VALUES (1,1,'5514997426610','4b3d1194-dc40-4f1c-a6d0-2ce0c4fd75d1','Divina Store');

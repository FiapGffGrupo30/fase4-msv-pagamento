
Pagamento - GFF
Api responsável por gerenciar os pagamentos da aplicação de Sistema de Gerenciamento de Fast Food.

Objetivo
A API de pagamentos possui as ferramentas que possibilitam ao cliente, criar, editar, pesquisar, alterar e deletar pagamentos dentros do sistema.

Tecnologias utilizadas
Git
Java - Versão 17
Maven
Docker
MongoDB
Swagger

Subindo a Aplicação
Para buildar a aplicação atarvés do download do programa via git é necessário ter as tecnologias Git, Java (versão 17 - sdk 17) e Docker instalados. Após instalar as tecnologias segua os seguintes passos:

1° - Baixe o diretório para uma pasta local de sua máquina.
2° - Abra o terminal no diretório na qual você fez o download da pasta do programa.
3° - Utilize o comando a seguir para para buildar a imagem localmente

    docker build -t gffpagamentos:latest .
4º Após realizar o build é possivel executar a imagem usando o seguinte comando:

docker container run gffpagamentos
Para acessar o Swagger da aplicação acesse em um browser de sua preferência o link:

http://localhost:8080/swagger-ui/index.html#/

No swagger você encontrará as rotas de utilização que a API proporciona.

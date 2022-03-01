# Projeto EDA e LEDA 
> Status: Finalizado ✅
> 

## O projeto consiste nas seguintes fases:
1. Preparação do DataSet  
    - Acessar o DataSet da Google Play Store através do [Link](https://www.kaggle.com/lava18/google-play-store-apps/version/6?select=googleplaystore.csv).  
    - Efetuar login ou se cadastrar na plataforma.
    - Fazer o download do dataset completo.
    - Transformar data (last_update) para DD/MM/AAAA:
        - Acessar o [Google Sheets](https://docs.google.com/spreadsheets/) e abrir o arquivo csv baixado . 
        - Vá para **`Arquivo > Configurações`** de planilha no menu do Planilhas Google.
        - Encontre Locale na guia General, escolha `United States` e salve.
        - Selecione todas as células que você deseja formatar.
        - Vá para **`Formatar > Número`** no menu da planilha e escolha o formato de data DD/MM/AAAA.
        - Faça o download e renomeie o arquivo para: `googleplaystore_date.csv`
        - Renomeie o arquivo para 
    - Efetuar a transformaçao de filtrar pelo genero diretamente no site do dataset, baixar e renomear para: `googleplaystore_genres.csv`
2. Análise dos algoritmos de ordenação
    - Implemente e utilize todos os algoritmos de ordenação estudados (Selection Sort, Insertion Sort, Merge Sort, Quick Sort, QuickSort com Mediana de 3, counting, e HeapSort) para ordenar os registros de acordo com os seguintes parâmetros:
        - Ordenar o arquivo completo de listagens pelo nomes dos aplicativos (campo App) em ordem alfabética
        - Ordenar o arquivo completo de listagens pelas notas de avaliação (campo ratings) dos lugares do menor para o maior
        - Ordenar o arquivo completo de listagens pelos número de instalações (campo installs) dos aplicativos do menor para o maior
        - Ordenar o arquivo completo de listagens pela data de última atualização (campo last_update) dos aplicativos do mais recente para o mais antigo.
    - Cada arquivo de saída de ordenação deve ser gerado com base no método de ordenação e no elemento ordenado. Por exemplo, para o quick sort devem ser gerado 3 arquivos: qSort_ordena_reviews.csv e qSort_ordena_prices.csv, qSort_ordena_places.csv. Isso deve continuar para cada um dos métodos de ordenação e para cada um dos projetos.
    - Elabore uma tabela para comparar o tempo de execução dos algoritmos.

>Opcional: Para a elaboração dos comparativos devem ser usados ferramentas de code profiling, como por exemplo o https://visualvm.github.io/ (Links para um site externo.). Elabore gráficos mostrando o consumo de tempo e memória quando da execução do algoritmo.

## Pré-Requisitos

1. Certifique-de de ter o Java instalado na sua maquina com o jdk 1.8 ou superior.
2. Utilizar uma IDE de Desenvolvimento java, Recomendo o [Visual Studio Code](https://code.visualstudio.com/)

## Tutorial para executar o projeto

1. Baixe o projeto, descompacte e abra ele usando uma IDE.
    - Clique em `CODE` e em seguinda `Download ZIP`
    <p align="left">
      <img src="https://user-images.githubusercontent.com/92695624/155892894-161d996f-b419-428e-9881-4fe4a2628096.jpg" />
    </p>
2.  copie os datasets que foram preparados para a pasta onde o projeto foi salvo.  
    - Certifique-se que os nomes estejam corretos: `googleplaystore_date.csv` , `googleplaystore_genres.csv`
3. Abra o *Main.java* e execute.
4. Escolha o algoritmo de ordenação que sera utilizado.
    <p align="left">
      <img src="https://user-images.githubusercontent.com/92695624/155894705-c8b5cc5a-7d25-4a2a-8f03-2de2917fc8bb.png" />
    </p>
5. Será impresso no terminal uma tabela contendo o metodo de ordenação, o campo que foi ordenado (App, Ratings, Installs, Last Update) juntamente com o caso e tempo(*ms*) em que foi executado.
    <p align="left">
      <img src="https://user-images.githubusercontent.com/92695624/155894983-29d20208-bba2-4307-b214-5206373dfa4c.jpg" />
    </p>
6. Os arquivos.csv vão ser criados.

## Observaçôes

> Os csv's irão ser gerados na mesma pasta do `Main.java`, nomeados de acordo com o algoritmo, campo ordenado e caso.

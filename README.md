# Back-end - Api-Stats-of-Youtube

Api que mostra as estatísticas da sua conta do Youtube, como por exemplo: canal mais assistido nos últimos 3 meses, desde da criação do canal, em um determinado dia

## Tecnologias

Este projeto foi desenvolvido com as seguintes Tecnologias

- Java
- Spring Boot
- Mavem
- Postman
- TakeOut

## Instruções para execução

Como a API do Youtube não disponibiliza o historico de visualização você terá que acessar utilizando o TakeOut.

Para acessar o Google Takeout e baixar o histórico de visualizações do YouTube siga:

- Acesse TakeOut takeout.google.com e faça login na sua conta do Google.
- Selecione o YouTube na lista de serviços disponíveis.
- Escolha o formato de arquivo como JSON.
- Em todos os dados deixe apenas histórico.
- Clique em "Exportar" e aguarde até que o arquivo de exportação esteja pronto para download.
- Baixe o arquivo exportado para o seu computador.

Com o histórico baixado coloque o arquivo neste caminho Api-Stats-of-Youtube\src\main\java\br\com\ufpb\statsyoutube\controller

Pronto, a API está pronta para uso, agora você pode vê todas as suas estatísticas do Youtube, desde quando você criou a sua conta, até os dias de hoje.

Rotas: 
```sh
    localhost:8080/channels
```
## API Reference

### Channels 

#### Listar todos os Canais que apareceram no seu histórico

```http
  GET /channels
```

| Parametros | Tipo     | Descrição                |
| :-------- | :------- | :------------------------- |
|  | | Este endpoint retorna todos os canais do seu histórico |

#### Response

| Code | Descrição                     |
| :--------  | :-------------------------------- |
| `200`       | Uma lista (Array) de canais |

#### Listar quantas vezes você assistiu cada canal desde a criação da conta

```http
  GET /channels/frequency
```

| Parametros | Tipo     | Descrição                     |
| :-------- | :------- | :-------------------------------- |
|   |  | Este endpoint retorna todos os canais e a frequencia que cada um foi assistida |

#### Response

| Code | Descrição                     |
| :--------  | :-------------------------------- |
| `200`       | Uma lista (Array) canais e sua frequencia |


#### Listar todos os canais que foram assistidos mais de 100 vezes

```http
  GET /channels/more100
```

| Parametros | Tipo     | Descrição                     |
| :-------- | :------- | :-------------------------------- |
|       |  | Este endpoint retorna todos os canais que foram assistidos mais de 100 vezes |

#### Response

| Code | Descrição                     |
| :--------  | :-------------------------------- |
| `200`       | Uma lista (Array) canais e sua frequencia |


#### Lista top X de canais mais visto, sendo X o parâmetro

```http
  GET /channels/topX/{X}
```

| Parametros | Tipo     | Descrição                     |
| :-------- | :------- | :-------------------------------- |
| `X`      | `Integer` | Este endpoint retorna os X canais mais visto pelo usuário |

#### Response

| Code | Descrição                     |
| :--------  | :-------------------------------- |
| `200`       | Uma lista (Array) de canais |

#### Lista os canais mais visto nos X ultimos meses, sendo X o parâmetro

```http
  GET /channels/lastMonth/{month}
```

| Parametros | Tipo     | Descrição                     |
| :-------- | :------- | :-------------------------------- |
| `month`      | `Integer` | Este endpoint retorna os canais mais visto pelo usuário nos ultimos X meses |

#### Response

| Code | Descrição                     |
| :--------  | :-------------------------------- |
| `200`       | Uma lista (Array) de canais |

#### Lista os canais mais visto nos X ultimos dias, sendo X o parâmetro

```http
  GET /channels/lastDays/{days}
```

| Parametros | Tipo     | Descrição                     |
| :-------- | :------- | :-------------------------------- |
| `days`      | `Integer` | Este endpoint retorna os canais mais visto pelo usuário nos ultimos X dias |

#### Response

| Code | Descrição                     |
| :--------  | :-------------------------------- |
| `200`       | Uma lista (Array) de canais |

#### Lista os canais mais visto em determinado ano

```http
  GET /channels/lastMonth/{year}
```

| Parametros | Tipo     | Descrição                     |
| :-------- | :------- | :-------------------------------- |
| `year`      | `Integer` | Este endpoint retorna os canais mais visto pelo usuário em determinado ano |

#### Response

| Code | Descrição                     |
| :--------  | :-------------------------------- |
| `200`       | Uma lista (Array) de canais |


## Inspiração

 - Stats for Spotify

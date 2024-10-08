# xuitter-api 🐦
Uma API REST para um 1/42 de um clone do X, o antigo Twitter. 

# Sobre o Xuitter

Xuitter é uma rede social minimalista com poucas funcionalidades. É uma volta às origens do Twitter, o saudoso predecessor do X.

# O que você deve fazer

Você deve implementar a **API REST com a plataforma Java** para a página principal (homepage) do Xuitter que permite:

- A homepage do Xuitter, mostra um feed de xuits (posts), começando com os últimos 5. Xuits mais antigos são carregados em lotes de 5 assim que o usuário faz o scroll no fim da página.
- Os xuits mostrados são tanto os posts normais como rexuits e citações (mais detalhes abaixo)
- Na homepage, é possível escolher entre os xuits de todo o Xuitter e apenas aqueles de pessoas que você segue.
- Também é possível realizar novos xuits na homepage do Xuitter. Mas o Xuitter tem uma restrição para fomentar a paz mundial: um usuário pode postar no máximo 2 xuits em um período de 24h da data/hora atual.

Não implemente nada além do necessário. Se for preciso, faça com que as informações sejam hardcoded.

## Para a próxima Sprint

Algumas funcionalidades importantes ficaram fora dessa Spring como:

- Autenticação (login) e Autorização
- Cadastro (sign up) de novo usuário
- Perfil público dos usuários, com os seus xuits, seguidores, etc
- Seguir outros usuários
- ...

# Entidades e regras

## Usuário

- Tem um username alfanumérico com até 10 caracters
- Podem seguir outros usuários
- Não podem seguir a si mesmos

## Xuit

- É apenas textual com, no máximo, 42 caracteres
- Há 3 tipos: xuits (posts normais), rexuits e citações
- Um rexuit permite que seja repostado um xuit original de outro usuário
- Uma citação é um rexuit com um comentário adicional
- Não é possível remover nem atualizar um xuit

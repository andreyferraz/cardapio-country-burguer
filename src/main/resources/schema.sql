CREATE TABLE IF NOT EXISTS categoria (
    id TEXT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    ordem_exibicao INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS produto (
    id TEXT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    imagem_url VARCHAR(255),
    ativo INTEGER NOT NULL DEFAULT 1 CHECK (ativo IN (0, 1)),
    categoria_id TEXT,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

CREATE TABLE IF NOT EXISTS adicional (
    id TEXT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    ativo INTEGER NOT NULL DEFAULT 1 CHECK (ativo IN (0, 1)),
    produto_id TEXT,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

CREATE TABLE IF NOT EXISTS pedido (
    id TEXT PRIMARY KEY,
    data_pedido DATETIME NOT NULL,
    nome_cliente VARCHAR(255) NOT NULL,
    telefone_cliente VARCHAR(255) NOT NULL,
    endereco_cliente VARCHAR(255) NOT NULL,
    observacoes TEXT,
    valor_total DECIMAL(10, 2) NOT NULL
);
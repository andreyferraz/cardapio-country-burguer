const menuData = [
    {
        id: "hamburgueres",
        title: "Hambúrgueres",
        description: "Blend artesanal, pão selado e ingredientes selecionados.",
        products: [
            {
                id: "x-country",
                name: "X-Country",
                description: "Carne 180g, cheddar, bacon, cebola caramelizada e molho da casa.",
                price: 29.9,
                image: "/img/food-placeholder.svg",
                ingredients: ["Pão", "Carne 180g", "Cheddar", "Bacon", "Cebola caramelizada", "Molho da casa"],
                additionals: [
                    { label: "Adicionar Ovo", price: 3.5 },
                    { label: "Adicionar Bacon Extra", price: 5.5 },
                    { label: "Adicionar Cream Cheese", price: 4.5 }
                ]
            },
            {
                id: "x-rustico",
                name: "X-Rústico",
                description: "Carne 150g, queijo prato, tomate grelhado e maionese defumada.",
                price: 25.9,
                image: "/img/food-placeholder.svg",
                ingredients: ["Pão", "Carne 150g", "Queijo prato", "Tomate grelhado", "Maionese defumada"],
                additionals: [
                    { label: "Adicionar Catupiry", price: 4.5 },
                    { label: "Adicionar Onion Rings", price: 6.0 }
                ]
            }
        ]
    },
    {
        id: "crepes",
        title: "Crepes",
        description: "Monte o recheio no estilo faroeste com combinações clássicas.",
        products: [
            {
                id: "crepe-3",
                name: "Crepe 3 Sabores",
                description: "Escolha 3 sabores: queijo, frango, apresuntado, milho, tomate, bacon, cebola.",
                price: 26.5,
                image: "/img/food-placeholder.svg",
                ingredients: ["Massa artesanal", "3 recheios à escolha"],
                additionals: [
                    { label: "Orégano, cenoura ou ovo", price: 2.5 },
                    { label: "Banana ou azeitona", price: 4.5 },
                    { label: "Catupiry, cheddar, batata palha", price: 4.5 },
                    { label: "Palmito ou calabresa", price: 5.5 },
                    { label: "Carne seca ou cream cheese", price: 8.0 }
                ]
            },
            {
                id: "crepe-4",
                name: "Crepe 4 Sabores",
                description: "Escolha 4 sabores na combinação que preferir.",
                price: 30.5,
                image: "/img/food-placeholder.svg",
                ingredients: ["Massa artesanal", "4 recheios à escolha"],
                additionals: [
                    { label: "Orégano, cenoura ou ovo", price: 2.5 },
                    { label: "Banana ou azeitona", price: 4.5 },
                    { label: "Catupiry, cheddar, batata palha", price: 4.5 },
                    { label: "Palmito ou calabresa", price: 5.5 },
                    { label: "Carne seca ou cream cheese", price: 8.0 }
                ]
            },
            {
                id: "crepe-5",
                name: "Crepe 5 Sabores",
                description: "Escolha 5 sabores para um crepe completo.",
                price: 34.5,
                image: "/img/food-placeholder.svg",
                ingredients: ["Massa artesanal", "5 recheios à escolha"],
                additionals: [
                    { label: "Orégano, cenoura ou ovo", price: 2.5 },
                    { label: "Banana ou azeitona", price: 4.5 },
                    { label: "Catupiry, cheddar, batata palha", price: 4.5 },
                    { label: "Palmito ou calabresa", price: 5.5 },
                    { label: "Carne seca ou cream cheese", price: 8.0 }
                ]
            }
        ]
    },
    {
        id: "porcoes",
        title: "Porções",
        description: "Porções para compartilhar ou atacar sozinho sem piedade.",
        products: [
            {
                id: "carne-fritas",
                name: "Carne com Fritas",
                description: "500g carne + 500g batata.",
                price: 63.0,
                image: "/img/food-placeholder.svg",
                ingredients: ["Carne", "Batata frita"],
                additionals: []
            },
            {
                id: "fritas-especial",
                name: "Fritas Especial",
                description: "500g com bacon e cheddar.",
                price: 31.5,
                image: "/img/food-placeholder.svg",
                ingredients: ["Batata frita", "Bacon", "Cheddar"],
                additionals: []
            },
            {
                id: "fritas-500",
                name: "Fritas 500g",
                description: "Porção tradicional de batata frita 500g.",
                price: 25.0,
                image: "/img/food-placeholder.svg",
                ingredients: ["Batata frita"],
                additionals: []
            },
            {
                id: "fritas-250",
                name: "Fritas 250g",
                description: "Porção tradicional de batata frita 250g.",
                price: 16.0,
                image: "/img/food-placeholder.svg",
                ingredients: ["Batata frita"],
                additionals: []
            }
        ]
    },
    {
        id: "sucos",
        title: "Sucos",
        description: "Naturais e gelados para acompanhar.",
        products: [
            {
                id: "suco-laranja",
                name: "Suco de Laranja",
                description: "Copo 400ml.",
                price: 9.0,
                image: "/img/food-placeholder.svg",
                ingredients: ["Laranja"],
                additionals: []
            }
        ]
    },
    {
        id: "bebidas",
        title: "Bebidas",
        description: "Refrigerantes e águas geladas.",
        products: [
            {
                id: "coca-lata",
                name: "Coca-Cola Lata",
                description: "350ml.",
                price: 6.5,
                image: "/img/food-placeholder.svg",
                ingredients: ["Refrigerante"],
                additionals: []
            }
        ]
    },
    {
        id: "acai",
        title: "Açaí",
        description: "Fechando o pedido com energia.",
        products: [
            {
                id: "acai-400",
                name: "Açaí 400ml",
                description: "Com granola e leite condensado.",
                price: 18.0,
                image: "/img/food-placeholder.svg",
                ingredients: ["Açaí", "Granola", "Leite condensado"],
                additionals: [
                    { label: "Paçoca", price: 2.0 },
                    { label: "Banana", price: 2.5 }
                ]
            }
        ]
    }
];

const state = {
    activeCategory: menuData[0].id,
    selectedProduct: null,
    cart: []
};

const refs = {
    categoryMenu: document.getElementById("categoryMenu"),
    mobileNavToggle: document.getElementById("mobileNavToggle"),
    activeCategoryTitle: document.getElementById("activeCategoryTitle"),
    activeCategoryDescription: document.getElementById("activeCategoryDescription"),
    productGrid: document.getElementById("productGrid"),
    productDrawer: document.getElementById("productDrawer"),
    drawerImage: document.getElementById("drawerImage"),
    drawerTitle: document.getElementById("drawerTitle"),
    drawerDescription: document.getElementById("drawerDescription"),
    drawerBasePrice: document.getElementById("drawerBasePrice"),
    ingredientsBlock: document.getElementById("ingredientsBlock"),
    additionalsBlock: document.getElementById("additionalsBlock"),
    drawerObservation: document.getElementById("drawerObservation"),
    drawerTotalPrice: document.getElementById("drawerTotalPrice"),
    confirmAddToCart: document.getElementById("confirmAddToCart"),
    cartItems: document.getElementById("cartItems"),
    cartCount: document.getElementById("cartCount"),
    cartTotal: document.getElementById("cartTotal"),
    checkoutBtn: document.getElementById("checkoutBtn"),
    checkoutSection: document.getElementById("checkoutSection"),
    checkoutForm: document.getElementById("checkoutForm"),
    cancelCheckout: document.getElementById("cancelCheckout"),
    confirmationSection: document.getElementById("confirmationSection"),
    newOrderBtn: document.getElementById("newOrderBtn"),
    goToMenuBtn: document.getElementById("goToMenuBtn")
};

function formatCurrency(value) {
    return value.toLocaleString("pt-BR", { style: "currency", currency: "BRL" });
}

function getCategoryById(categoryId) {
    return menuData.find((category) => category.id === categoryId);
}

function buildCategoryNav() {
    refs.categoryMenu.innerHTML = "";
    menuData.forEach((category) => {
        const li = document.createElement("li");
        const button = document.createElement("button");
        button.type = "button";
        button.textContent = `☀ ${category.title}`;
        button.setAttribute("aria-current", category.id === state.activeCategory ? "true" : "false");
        button.addEventListener("click", () => {
            state.activeCategory = category.id;
            refs.categoryMenu.classList.remove("open");
            refs.mobileNavToggle.setAttribute("aria-expanded", "false");
            buildCategoryNav();
            renderProducts();
        });
        li.appendChild(button);
        refs.categoryMenu.appendChild(li);
    });
}

function renderProducts() {
    const category = getCategoryById(state.activeCategory);
    if (!category) return;

    refs.activeCategoryTitle.textContent = category.title;
    refs.activeCategoryDescription.textContent = category.description;
    refs.productGrid.innerHTML = "";

    category.products.forEach((product) => {
        const card = document.createElement("article");
        card.className = "product-card";
        card.innerHTML = `
            <img src="${product.image}" alt="${product.name}" loading="lazy">
            <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p class="price-handwritten">${formatCurrency(product.price)}</p>
            <button type="button">✦ Adicionar ao Carrinho</button>
        `;

        card.querySelector("button").addEventListener("click", () => {
            openProductDrawer(product);
        });

        refs.productGrid.appendChild(card);
    });
}

function openProductDrawer(product) {
    state.selectedProduct = {
        ...product,
        removedIngredients: [],
        selectedAdditionals: [],
        observation: ""
    };

    refs.drawerImage.src = product.image;
    refs.drawerTitle.textContent = product.name;
    refs.drawerDescription.textContent = product.description;
    refs.drawerBasePrice.textContent = formatCurrency(product.price);
    refs.drawerObservation.value = "";

    renderIngredientOptions(product.ingredients || []);
    renderAdditionalOptions(product.additionals || []);
    updateDrawerTotal();

    refs.productDrawer.classList.add("open");
    refs.productDrawer.setAttribute("aria-hidden", "false");
}

function closeProductDrawer() {
    refs.productDrawer.classList.remove("open");
    refs.productDrawer.setAttribute("aria-hidden", "true");
    state.selectedProduct = null;
}

function renderIngredientOptions(ingredients) {
    refs.ingredientsBlock.innerHTML = "";
    if (!ingredients.length) return;

    const container = document.createElement("div");
    container.innerHTML = `<h4>Ingredientes (desmarque para remover)</h4>`;

    const options = document.createElement("div");
    options.className = "drawer-options";

    ingredients.forEach((ingredient) => {
        const label = document.createElement("label");
        label.className = "drawer-option";

        const text = document.createElement("span");
        text.textContent = ingredient;

        const checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.checked = true;
        checkbox.addEventListener("change", () => {
            if (checkbox.checked) {
                state.selectedProduct.removedIngredients = state.selectedProduct.removedIngredients.filter((item) => item !== ingredient);
            } else {
                state.selectedProduct.removedIngredients.push(ingredient);
            }
        });

        label.append(text, checkbox);
        options.appendChild(label);
    });

    container.appendChild(options);
    refs.ingredientsBlock.appendChild(container);
}

function renderAdditionalOptions(additionals) {
    refs.additionalsBlock.innerHTML = "";
    if (!additionals.length) return;

    const container = document.createElement("div");
    container.innerHTML = "<h4>Adicionais</h4>";

    const options = document.createElement("div");
    options.className = "drawer-options";

    additionals.forEach((additional, index) => {
        const label = document.createElement("label");
        label.className = "drawer-option";

        const text = document.createElement("span");
        text.textContent = `${additional.label} (${formatCurrency(additional.price)})`;

        const checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.addEventListener("change", () => {
            if (checkbox.checked) {
                state.selectedProduct.selectedAdditionals.push({ ...additional, key: `${additional.label}-${index}` });
            } else {
                state.selectedProduct.selectedAdditionals = state.selectedProduct.selectedAdditionals.filter(
                    (item) => item.key !== `${additional.label}-${index}`
                );
            }
            updateDrawerTotal();
        });

        label.append(text, checkbox);
        options.appendChild(label);
    });

    container.appendChild(options);
    refs.additionalsBlock.appendChild(container);
}

function updateDrawerTotal() {
    if (!state.selectedProduct) return;
    const additionalsTotal = state.selectedProduct.selectedAdditionals.reduce((total, item) => total + item.price, 0);
    const itemTotal = state.selectedProduct.price + additionalsTotal;
    refs.drawerTotalPrice.textContent = formatCurrency(itemTotal);
}

function addCurrentProductToCart() {
    if (!state.selectedProduct) return;

    const additionalsTotal = state.selectedProduct.selectedAdditionals.reduce((total, item) => total + item.price, 0);
    const unitPrice = state.selectedProduct.price + additionalsTotal;

    const cartItem = {
        id: crypto.randomUUID(),
        productId: state.selectedProduct.id,
        name: state.selectedProduct.name,
        quantity: 1,
        unitPrice,
        basePrice: state.selectedProduct.price,
        removedIngredients: [...state.selectedProduct.removedIngredients],
        selectedAdditionals: [...state.selectedProduct.selectedAdditionals],
        observation: refs.drawerObservation.value.trim()
    };

    state.cart.push(cartItem);
    closeProductDrawer();
    renderCart();
}

function changeCartItemQty(itemId, direction) {
    const item = state.cart.find((cartItem) => cartItem.id === itemId);
    if (!item) return;

    item.quantity += direction;
    if (item.quantity <= 0) {
        state.cart = state.cart.filter((cartItem) => cartItem.id !== itemId);
    }
    renderCart();
}

function removeCartItem(itemId) {
    state.cart = state.cart.filter((item) => item.id !== itemId);
    renderCart();
}

function renderCart() {
    refs.cartItems.innerHTML = "";

    if (!state.cart.length) {
        refs.cartItems.innerHTML = "<p class='cart-empty'>Seu carrinho está vazio.</p>";
    }

    state.cart.forEach((item) => {
        const cartItem = document.createElement("article");
        cartItem.className = "cart-item";

        const removedInfo = item.removedIngredients.length
            ? `Sem: ${item.removedIngredients.join(", ")}`
            : "";

        const additionalInfo = item.selectedAdditionals.length
            ? `Adicionais: ${item.selectedAdditionals.map((additional) => additional.label).join(", ")}`
            : "";

        cartItem.innerHTML = `
            <p class="cart-item-title">${item.name}</p>
            <p class="cart-item-details">${removedInfo}</p>
            <p class="cart-item-details">${additionalInfo}</p>
            <p class="cart-item-details">${item.observation ? `Obs: ${item.observation}` : ""}</p>
            <div class="cart-item-actions">
                <div class="qty-controls">
                    <button type="button" data-action="minus">-</button>
                    <span>${item.quantity}</span>
                    <button type="button" data-action="plus">+</button>
                </div>
                <strong>${formatCurrency(item.unitPrice * item.quantity)}</strong>
                <button type="button" class="remove-item">Remover</button>
            </div>
        `;

        cartItem.querySelector("[data-action='minus']").addEventListener("click", () => changeCartItemQty(item.id, -1));
        cartItem.querySelector("[data-action='plus']").addEventListener("click", () => changeCartItemQty(item.id, 1));
        cartItem.querySelector(".remove-item").addEventListener("click", () => removeCartItem(item.id));
        refs.cartItems.appendChild(cartItem);
    });

    const totalItems = state.cart.reduce((sum, item) => sum + item.quantity, 0);
    const totalPrice = state.cart.reduce((sum, item) => sum + item.unitPrice * item.quantity, 0);

    refs.cartCount.textContent = `${totalItems} ${totalItems === 1 ? "item" : "itens"}`;
    refs.cartTotal.textContent = formatCurrency(totalPrice);
}

function openCheckout() {
    if (!state.cart.length) {
        alert("Adicione pelo menos um item ao carrinho antes de finalizar.");
        return;
    }
    refs.checkoutSection.classList.add("open");
    refs.checkoutSection.setAttribute("aria-hidden", "false");
}

function closeCheckout() {
    refs.checkoutSection.classList.remove("open");
    refs.checkoutSection.setAttribute("aria-hidden", "true");
}

function openConfirmation() {
    refs.confirmationSection.classList.add("open");
    refs.confirmationSection.setAttribute("aria-hidden", "false");
}

function closeConfirmation() {
    refs.confirmationSection.classList.remove("open");
    refs.confirmationSection.setAttribute("aria-hidden", "true");
}

function validateCheckoutForm() {
    const formData = new FormData(refs.checkoutForm);
    const requiredFields = ["customerName", "customerPhone", "customerAddress", "paymentMethod"];

    for (const field of requiredFields) {
        const value = formData.get(field);
        if (!value || String(value).trim().length === 0) {
            return false;
        }
    }

    return true;
}

function completeOrder(event) {
    event.preventDefault();

    if (!validateCheckoutForm()) {
        alert("Preencha todos os campos obrigatórios para concluir o pedido.");
        return;
    }

    closeCheckout();
    openConfirmation();
}

function resetOrderFlow() {
    state.cart = [];
    refs.checkoutForm.reset();
    renderCart();
    closeConfirmation();
}

function registerEvents() {
    refs.mobileNavToggle.addEventListener("click", () => {
        const isOpen = refs.categoryMenu.classList.toggle("open");
        refs.mobileNavToggle.setAttribute("aria-expanded", String(isOpen));
    });

    refs.goToMenuBtn.addEventListener("click", () => {
        document.getElementById("menu").scrollIntoView({ behavior: "smooth" });
    });

    document.querySelectorAll("[data-close-drawer='true']").forEach((element) => {
        element.addEventListener("click", closeProductDrawer);
    });

    refs.confirmAddToCart.addEventListener("click", addCurrentProductToCart);
    refs.checkoutBtn.addEventListener("click", openCheckout);
    refs.cancelCheckout.addEventListener("click", closeCheckout);
    refs.checkoutForm.addEventListener("submit", completeOrder);
    refs.newOrderBtn.addEventListener("click", resetOrderFlow);
}

function init() {
    buildCategoryNav();
    renderProducts();
    renderCart();
    registerEvents();
}

init();

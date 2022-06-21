import Lista from './components/lista/Lista.vue';
import Cadastro from './components/cadastro/CadastroDeItem.vue';

export const routes = [
    { path: '/lista', name: 'lista', component: Lista, titulo: 'Lista'},
    { path: '/cadastro', name: 'cadastro', component: Cadastro, titulo: 'Cadastro de item'}
];
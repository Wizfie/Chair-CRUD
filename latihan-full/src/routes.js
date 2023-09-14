import Add from './Pages/Add.vue'
import Home from './Pages/Home.vue'
import Update from './Pages/Update.vue'

export default [
    {   path:"/",
        component:Home,

    },

    {
        path: "/Add",
        component: Add,
    },
    {
        path:"/Update/:id",
        component: Update,
        name:'updateData'
    }

    
]
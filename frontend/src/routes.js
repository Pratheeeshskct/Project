import Login from "./pages/Login";
import SignUp from "./pages/SignUp";
import Home from "./pages/Home";
import Error404 from "./pages/Error404";

export const routes = [
    {
        path:"/login",
        element:<Login/>
    },
    {
        path:"/signup",
        element:<SignUp/>
    },
    {
        path:"/",
        element:<Home/>
    },
    {
        path:"*",
        element:<Error404/>
    }
];
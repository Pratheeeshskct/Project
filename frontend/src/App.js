import React from 'react'
import {routes} from './routes'
import { useRoutes } from 'react-router-dom'

export default function App() {
  const content = useRoutes(routes);
  return (
    <div>
      {content}
    </div>
  )
}

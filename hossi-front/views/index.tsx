import React from 'react';
import { Head } from '@react-ssr/express';

interface IndexProps {
  user: any;
}

const Index = ({ user }: IndexProps) => {
  const [message, setMessage] = React.useState('waiting...');

  const onClick = () => setMessage('This is a react-ssr!');

  return (
    <React.Fragment>
      <Head>
        <title>
          basic-tsx - @react-ssr/express
        </title>
      </Head>
      <p>Hello {user.name}!</p>
      <button onClick={onClick}>Click Me</button>
      <p>Message from state: {message}</p>
    </React.Fragment>
  );
};

export default Index;

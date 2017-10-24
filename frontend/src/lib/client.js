import path from 'path';

const BASE_URL = 'http://localhost:3000/';

export const get = (path, options = {}) => {
  return fetch(`${BASE_URL}${path}`, {
    method: 'GET',
    ...options
  });
}

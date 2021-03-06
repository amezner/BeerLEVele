import join from 'url-join';
import AuthStore from '../stores/authorization';

const BASE_URL = `http://${window.location.hostname}:8080/RFT_BEERLEVELE-war/resources/`;

const addHeaders = options => {
  const result = {
    ...options
  };

  if (!result.headers) {
    result.headers = {};
  }
  
  if (localStorage.getItem('authToken')) {
    result.headers.authToken = localStorage.getItem('authToken');
  }

  return result;
}

const attachHandlers = promise => promise.then(response => new Promise((resolve, reject) => {
  if (response.status === 401) {
    AuthStore.logout();
  }
  else if (response.ok && response.status === 204) {
    return resolve();
  }

  response.json().then(response.ok
    ? resolve
    : reject);
}))

const methodFactory = (method, bodyAllowed = true) => {
  const defaultOptions = {
    method
  };

  if (bodyAllowed) {
    return (path, body, options = {
      headers: {}
    }) => {
      options = addHeaders(options);
      return attachHandlers(fetch(join(BASE_URL, path), {
        ...defaultOptions,
        ...options,
        headers: {
          ...defaultOptions.headers,
          ...options.headers,
          'Content-Type': 'application/json;charset=utf-8'
        },
        cache: 'no-store',
        body: JSON.stringify(body)
      }));
    }
  }

  return (path, options) => {
    options = addHeaders(options);

    return attachHandlers(fetch(join(BASE_URL, path), {
      ...defaultOptions,
      ...options
    }));
  }
}

export const get = methodFactory('GET', false);
export const post = methodFactory('POST');
export const put = methodFactory('PUT');
export const patch = methodFactory('PATCH');
export const del = methodFactory('DELETE');

export const validateEmail = (email: string): boolean => {
  const regX = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  return regX.test(email);
};

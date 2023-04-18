const person = {
  name: 'saikat',
  age: '38',
  greet(){
    console.log('Hi Bro!! ' + this.name);
  }  
};

const anotherPerson = {
    greet: () => {
        console.log('Hi Bro, I am New');
    }
}

const hobbies = ['sports', 123, 'another', true];

person.greet();
anotherPerson.greet();


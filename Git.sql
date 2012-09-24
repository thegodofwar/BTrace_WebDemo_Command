1.ssh-keygen -t rsa -C "thegodofwar9@gmail.com"

2.git config --global user.name "thegodofwar"
  git config --global user.email thegodofwar9@gmail.com
  
3.git init

4.git add .

5.git commit -m "...Notice...liufukun123..."

  | 6.git remote add origin git@github.com:thegodofwar/test.git

  | 7.git config branch.master.remote origin 
      git config branch.master.merge refs/heads/master 
  
  | 8.git pull

9.git push -u origin master  


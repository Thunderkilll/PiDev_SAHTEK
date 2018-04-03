<?php

namespace UserBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use UserBundle\Entity\Articles;

class DefaultController extends Controller
{

    public function AgentAction()
    {

        $m=$this->getDoctrine()->getManager();
        $users=$m->getRepository('UserBundle:User')->findAll();
        return $this->render('UserBundle::Page_Agent.html.twig',array('users'=>$users));
    }
    public function AdminAction()
    {
        $m=$this->getDoctrine()->getManager();
        $users=$m->getRepository('UserBundle:User')->findAll();
        return $this->render(':default:Page_Agent.html.twig',array('users'=>$users));
    }
    public function ClientAction()
    {
        $m=$this->getDoctrine()->getManager();
        $articles=$m->getRepository('UserBundle:Articles')->findAll();

        return $this->render('UserBundle::Page_Client.html.twig',array('article'=>$articles));
    }
    public function ServicesAction()
    {
    return $this->render('UserBundle:menu_options:services.html.twig');
    }

    public function ProduitsAction()
    {
        return $this->render('UserBundle:menu_options:produits.html.twig');
    }


    public function ArticlesAction()
    {
        return $this->render('UserBundle:menu_options:QandA.html.twig');
    }
    public function imagesAction()
    {
        return $this->render('UserBundle::test.html.twig');
    }

    public function AfficherQuestionAction(Articles $article){
        return $this->render('UserBundle:menu_options:questionAffiche.html.twig', array(
            'article' => $article ));

    }
}

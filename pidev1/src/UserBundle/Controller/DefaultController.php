<?php

namespace UserBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        $m=$this->getDoctrine()->getManager();
        $articles=$m->getRepository('UserBundle:Articles')->findAll();
        return $this->render('UserBundle::index.html.twig',array('article'=>$articles));
    }
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

}

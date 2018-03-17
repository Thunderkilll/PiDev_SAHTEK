<?php

namespace UserBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('UserBundle::index.html.twig');
    }
    public function AgentAction()
    {
        return $this->render('UserBundle::Page_Agent.html.twig');
    }
    public function AdminAction()
    {
        return $this->render(':default:PageAdmin.html.twig');
    }
    public function ClientAction()
    {
        return $this->render('UserBundle::Page_Client.html.twig');
    }

}
